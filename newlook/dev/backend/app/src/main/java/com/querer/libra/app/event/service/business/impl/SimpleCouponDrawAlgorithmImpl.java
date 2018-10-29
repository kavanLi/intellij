/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service.business.impl;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.querer.libra.app.event.domain.entity.Event;
import com.querer.libra.app.event.domain.entity.Rule;
import com.querer.libra.app.event.domain.entity.SharedEvent;
import com.querer.libra.app.event.domain.entity.UserCoupon;
import com.querer.libra.app.event.exception.ExhaustedDrawChancesException;
import com.querer.libra.app.event.service.atom.RuleService;
import com.querer.libra.app.event.service.atom.SharedEventService;
import com.querer.libra.app.event.service.business.CouponDrawAlgorithm;
import com.querer.libra.app.event.service.business.UserCouponQueryService;
import com.querer.libra.app.event.util.DateTimeUtil;
import org.springframework.stereotype.Service;

/**
 * 实现接口CouponDrawAlgorithm.
 */
//注解.
@Service
public class SimpleCouponDrawAlgorithmImpl implements CouponDrawAlgorithm {

    /**
     * fields.
     */

    /**
     * 声明一个常量对象logger,是一个日志管理器.
     */
    private final static Logger logger = LoggerFactory.getLogger(SimpleCouponDrawAlgorithmImpl.class);
    /**
     * 声明一个常量MAX_NUMBER = 10000.还有一些可能用到的常量.
     */
    private final static int MAX_NUMBER = 10000;
    private final static int MAX_NUMBER_2 = 5000;
    private final static int MAX_NUMBER_3 = 2501;
    private final static int MAX_NUMBER_4 = 2500;
    private final static int MAX_NUMBER_5 = 1000;
    /**
     * 声明一个私有的Int类型数据,timesPerDay = 1.
     */
    private int timesPerDay = 1;
    /**
     * 声明一个UserCouponQueryService接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private UserCouponQueryService userCouponQueryService;
    /**
     * 声明一个SharedEventService接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private SharedEventService sharedEventService;
    /**
     * 声明一个RuleService接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private RuleService ruleService;

    /**
     * public methods.
     */

    /**
     * 抽奖
     *
     * @param event target info.
     * @param uid   target info.
     * @return 抽奖结果以实例optional返回, 值为userCoupon.
     */
    @Override
    public Optional <UserCoupon> drawCoupon(Event event, String uid) {
        //如果传入的event和uid有一个为空,或都为空进入该语句块.
        if (event == null || StringUtils.isBlank(uid)) {
            //返回值为空的optional实例.
            return Optional.empty();
        }
        /**
         * check user opportunity first 检查用户抽奖次数是否用完.
         */
        //int times = this.timesPerDay;
        int times = 50;
        //通过event_oid和uid找到匹配的SharedEvent并赋值给类型为SharedEvent的集合sharedEventList.
        //FIXME 没有匹配当天的时间,有bug.
        List <SharedEvent> sharedEventList = sharedEventService.findByEventOidAndUid(event.getOid(), uid);
        //如果sharedEventList不为空,则进入该语句块.
        if (CollectionUtils.isNotEmpty(sharedEventList)) {
            //抽奖次数加1.
            times += 1;
        }
        //通过uid查询今天用户的的userCoupon,返回值为userCoupon的集合userCouponList.
        List <UserCoupon> userCouponList = userCouponQueryService.findUserCouponsToday(uid);
        //如果抽奖次数<=用户今天的coupon数量,进入下面的语句.
        if (times <= CollectionUtils.size(userCouponList)) {
            //抛出一个带有说明的异常:用户的抽奖次数已经用完.
            throw new ExhaustedDrawChancesException("user has tried out all the chances today.");
        }
        /**
         * load event and rules for today 现在的情况是用户还有抽奖次数.
         */
        //通过event_oid查询今天的抽奖规则.
        List <Rule> ruleList = ruleService.findRulesToday(event.getOid());
        //声明类型为Rule的引用变量hitRule,并空指针引用.
        Rule hitRule = null;
        // BigDemical类型的引用变量probability,调用其静态方法赋值为0.
        BigDecimal probability = BigDecimal.ZERO;
        //BigDemical类型的引用变量hitRandomNumber,调用其静态方法赋值为0.
        BigDecimal hitRandomNumber = BigDecimal.ZERO;
        //如果ruleList存在元素,则进入该语句块.
        if (CollectionUtils.isNotEmpty(ruleList)) {
            // calc probability.

            /*可能用到的算法

            Origin:
            int randomNumber = ThreadLocalRandom.current().nextInt(1, MAX_NUMBER);

            A:
            int randomNumber = ThreadLocalRandom.current().nextInt(1, MAX_NUMBER_2);
            int a = (int)(Math.random()*MAX_NUMBER_3);
            int b = new Random().nextInt(MAX_NUMBER_3);
            int c = (randomNumber + a + b);

            B:
            int a = ThreadLocalRandom.current().nextInt(1, MAX_NUMBER_2);
            int b = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_4);
            int d = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_4);
            int c = (a + b + d);

            C:
            int a = ThreadLocalRandom.current().nextInt(1, MAX_NUMBER_2);
            int b = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_2);
            int c = (a + b);

            D:
            int a = ThreadLocalRandom.current().nextInt(1, MAX_NUMBER_2);
            int b = new Random().nextInt(MAX_NUMBER_2);
            int c = (a + b);

            E:
            int a = ThreadLocalRandom.current().nextInt(1, MAX_NUMBER_2);
            int b = (int)(Math.random()*MAX_NUMBER_2);
            int c = (a + b);

            F:
            int a = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int b = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int d = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int e = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int f = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int g = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int h = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int i = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int j = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int k = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER_5);
            int c = (a + b + d + e + f + g + h + i + j + k);

            G:
            int a = new Random().nextInt(MAX_NUMBER_2);
            int b = (int)(Math.random()*MAX_NUMBER_2 + 1);
            int c = (a + b);
            */

            /**
             * 下面的是当前的算法,找到Java api中可以生成随机数的3中方法,分别让其生成3位数,4位数和5位数的整型伪随机数 <br>
             * 让三个伪随机数相成并转换成long型的整数rand4,然后把rand4倒序排列形成一个新的long型的整数rand5. <br>
             * rand5对10000取余数然后并+1,再转换成int型的整数赋值给randomNumber. <br>
             * randomNumber的取值范围是(1,10000).就把randomNumber作为用户每次抽奖得到的数. <br>
             * 补充:Random().nextInt()比Math.random()更加准确和高效(运行速度).
             */
            //System.out.println(ran1);
            int ran1 = ThreadLocalRandom.current().nextInt(10000, 99999);
            //System.out.println(ran2);
            int ran2 = new Random().nextInt(9000) + 1000;
            //System.out.println(ran3);
            int ran3 = (int) (Math.random() * 900 + 100);
            //System.out.println(rand4);
            long rand4 = ((long) ran1 * (long) ran2 * (long) ran3);
            //System.out.println(rand4);
            String rand5 = new StringBuilder(String.valueOf(rand4)).reverse().toString();
            //System.out.println(rand4);
            long test_unuse = Long.parseLong(rand5) % 10000;
            //System.out.println(rand4);
            int randomNumber = (int) (Long.parseLong(rand5) % 10000 + 1);

            //把randomNumber/MAX_NUMBER得到一个精度位4位的小数然后赋值给BigDecimal类型的hitNumber.
            BigDecimal hitNumber = new BigDecimal(randomNumber).divide(new BigDecimal(MAX_NUMBER));

            //日志管理器,调用debug方法记录uid,和hitNumber.
            logger.debug("user {} draw coupon with hit rate number: {} ", uid, hitNumber);

            /**
             * match 用hitNumber来查询抽奖规则,匹配奖品.
             */
            /*
            对今天的抽奖规则集合ruleList进行遍历,ruleList的值赋值给rule.循环的顺序根据每个奖项优先级
            从1开始到最后一个数.
             */
            for (Rule rule : ruleList) {
                //把当前奖品对应的probability取出赋值给ruleProbability.
                BigDecimal ruleProbability = rule.getProbability();
                //如果存在,进入该语句块.
                if (ruleProbability != null) {
                    //probability的值加上ruleProbability的值.
                    probability = probability.add(ruleProbability);
                    //如果hitNumber > probability 则进入该语句块,继续循环.
                    if (hitNumber.compareTo(probability) > 0) {
                        continue;
                    } else {
                        /**
                         * check constraints
                         */
                        /*
                        如果本次循环的rule匹配约束条件,则进入该语句块,如果对应等级的奖品抽完了,则什么都不做
                        继续循环,直到有剩余奖品的那一级.具体细节看方法isMatchRuleConstraints.
                         */
                        if (isMatchRuleConstraints(rule)) {
                            // 把rule赋值给hitRule,hitNumber赋值给hitRandomNumber,结束循环.
                            hitRule = rule;
                            hitRandomNumber = hitNumber;
                            break;
                        }
                    }
                }
            }
        }

        /**
         * hit coupons,中奖了,记录用户中奖信息.
         */
        //声明一个UserCoupon类型的对象,空指针.
        UserCoupon userCoupon = null;
        //如果hitRule存在则进入该语句块.
        if (hitRule != null) {
            //给userCoupon赋值属性uid, event, rule_oid, hitRandomNumber, coupon.
            userCoupon = new UserCoupon();
            userCoupon.setUid(uid);
            userCoupon.setEvent(event);
            userCoupon.setRuleOid(hitRule.getOid());
            userCoupon.setHitRandomNumber(hitRandomNumber);
            userCoupon.setCoupon(hitRule.getCoupon());
        }
        //返回值为userCoupon的Optional实例.
        return Optional.ofNullable(userCoupon);
    }

    /**
     * 查看抽到的奖品是否还有奖池
     *
     * @param rule target info,传入的是当天匹配优先级下的抽奖规则.
     * @return boolean
     */
    private boolean isMatchRuleConstraints(Rule rule) {
        /**
         * process day capacity first 判断今天还有没有对应奖品的库存.
         */
        //声明变量取得今天的日期时间.
        boolean result = true;
        Date now = new Date();
        Date startDate = DateTimeUtil.getStartOfDay(now);
        Date endDate = DateTimeUtil.getEndOfDay(now);
        /*
        通过方法查询今天匹配rule_oid的userCoupon发放了多少个,并赋值给fullDayCountNumber.
        通过ruleOid的查询方式让适用于各家店匹配各自的奖池.
        通过couponOid的查询方式可以让多家店共享一个奖池.
         */

        //Long fullDayCountNumber = userCouponQueryService.countUserCouponsBetweenRange(rule.getOid(), startDate, endDate);
        //Long fullDayCountNumber = userCouponQueryService.countUserCouponsBetweenRange(1L, startDate, endDate);
        Long fullDayCountNumber = userCouponQueryService.countUserCouponsBetweenRangea(rule.getCoupon().getOid(), startDate, endDate);
        //提取今天对应优先级(或者说oid)的抽奖规则的奖品的个数一共多少个.
        Integer dayCapacity = rule.getDayCapacity();
        // if total user coupons exceeds day capacity, then end.
        if (dayCapacity != null) {
            //如果对应奖池的容量 <= 今天抽到该奖的次数 则进入该语句块.
            if (NumberUtils.compare(dayCapacity, fullDayCountNumber) <= 0) {
                result = false;
                //返回restlt = false.该奖已经被抽完了,匹配下一级奖项
                return result;
            }
        }

        LocalDateTime nowLdt = DateTimeUtil.dateToLocalDateTime(now);
        LocalDate today = LocalDate.now();
        LocalTime midday = LocalTime.of(12, 0); // 12:00
        LocalDateTime middayLdt = LocalDateTime.of(today, midday);
        Date middayDate = DateTimeUtil.localDateTimeToDate(middayLdt);

        if (nowLdt.getHour() <= 12) {
            // AM
            Integer dayAmCapacity = rule.getDayAmCapacity();
            if (dayAmCapacity != null) {
                Long amDayCountNumber = userCouponQueryService.countUserCouponsBetweenRange(rule.getOid(), startDate, middayDate);
                if (NumberUtils.compare(dayAmCapacity, amDayCountNumber) <= 0) {
                    result = false;
                    return result;
                }
            }
        } else {
            // PM
            Integer dayPmCapacity = rule.getDayPmCapacity();
            if (dayPmCapacity != null) {
                Long pmDayCountNumber = userCouponQueryService.countUserCouponsBetweenRange(rule.getOid(), middayDate, endDate);
                if (NumberUtils.compare(dayPmCapacity, pmDayCountNumber) <= 0) {
                    result = false;
                    return result;
                }
            }
        }

        return result;
    }

    /* getters/setters ----------------------------------------------------- */

    public int getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(int timesPerDay) {
        this.timesPerDay = timesPerDay;
    }
}
