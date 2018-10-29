/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.querer.libra.app.event.dal.repository.UserCouponRepository;
import com.querer.libra.platform.code.UniqueCodeGenerator;
import com.querer.libra.platform.code.impl.DefaultUniqueCodeGeneratorImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querer.libra.app.event.domain.entity.Event;
import com.querer.libra.app.event.domain.entity.UserCoupon;
import com.querer.libra.app.event.domain.model.UserCouponModel;
import com.querer.libra.app.event.exception.EventClosedException;
import com.querer.libra.app.event.exception.EventNotFoundException;
import com.querer.libra.app.event.exception.InvalidUserCouponException;
import com.querer.libra.app.event.exception.NotYourCouponException;
import com.querer.libra.app.event.exception.ParameterRequiredException;
import com.querer.libra.app.event.exception.UserCouponExpiredException;
import com.querer.libra.app.event.exception.UserCouponIsUsedException;
import com.querer.libra.app.event.exception.UserCouponNotFoundException;
import com.querer.libra.app.event.service.atom.EventService;
import com.querer.libra.app.event.service.atom.UserCouponService;
import com.querer.libra.app.event.service.business.CouponDrawAlgorithm;
import com.querer.libra.app.event.service.business.UserCouponBizService;
import com.querer.libra.app.event.service.business.UserCouponQueryService;

/**
 * 实现接口UserCouponBizService.
 */
//注解.
@Service
public class UserCouponBizServiceImpl implements UserCouponBizService {

    /**
     * fields.
     */

    /**
     * 声明一个UserCouponService接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private UserCouponService userCouponService;
    /**
     * 声明一个UserCouponQueryService接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private UserCouponQueryService userCouponQueryService;
    /**
     * 声明一个EventService接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private EventService eventService;
    /**
     * 声明一个CouponDrawAlgorithm接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private CouponDrawAlgorithm couponDrawAlgorithm;
    /**
     * 声明一个Mapper接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private Mapper beanMapper;

    @Autowired
    private UniqueCodeGenerator uniqueCodeGenerator;

    @Autowired
    private UserCouponRepository userCouponRepository;
    /**
     * public methods.
     */

    /**
     * 抽奖
     *
     * @param userCouponModel 传入userCouponModel,带有uid, occurTime, event的openingCode三个信息.
     * @return 完整信息的userCouponModel.
     */
    @Override
    public UserCouponModel doDrawCoupon(@NotNull UserCouponModel userCouponModel) {
        // check uid
        String uid = userCouponModel.getUid();
        //uid不为空,进入下面语句块.
        if (StringUtils.isBlank(uid)) {
            //抛出一个带有说明的异常:需要uid.
            throw new ParameterRequiredException("uid is required.");
        }

        // check event
        //声明一个值为空的openingCode
        String openingCode = StringUtils.EMPTY;
        //如果传入的userCouponModel有event的值(只有openingCode),且不为空则进入下面语句块.
        if (userCouponModel.getEvent() != null) {
            //把event的openingCode的值取出赋值给声明的openingCode.
            openingCode = userCouponModel.getEvent().getOpeningCode();
        }
        //查询匹配openingCode的event的完整信息并赋值给eventOptional.
        Optional <Event> eventOptional = eventService.findByOpeningCode(openingCode);
        //如果eventOptional的值不存在,则进入下面的语句.
        if (!eventOptional.isPresent()) {
            //抛出一个带有说明的异常:通过openingCode没有找到匹配的event,
            throw new EventNotFoundException("cannot find event with opening code: " + openingCode);
        }
        //如果eventOptional的值为存在,但是过期了(enabled的值为0,对应false),则进入下面的语句.
        if (!eventOptional.get().getEnabled()) {
            throw new EventClosedException("event is closed");
        }

        // TODO sync issue when draw...
        //传入完整的event信息和uid进行规定算法的抽奖,返回值给userCouponOptional.
        Optional <UserCoupon> userCouponOptional = couponDrawAlgorithm.drawCoupon(eventOptional.get(), uid);
        //声明一个model来接收userCouponOptional的信息.
        UserCouponModel model;
        //如果userCouponOptional存在,则进入下面的语句.
        if (userCouponOptional.isPresent()) {
            /*
                把userCouponOptional的值赋于userCoupon,设定uid, event, occurTime, submitTime,
                startTime, endTime, used(没用过).
             */
            UserCoupon userCoupon = userCouponOptional.get();

            //生成条形码.
            long longBarcode = 0;
            if (3 <= userCoupon.getCoupon().getOid() && userCoupon.getCoupon().getOid() <= 5) {

                //UniqueCodeGenerator uniqueCodeGenerator = new DefaultUniqueCodeGeneratorImpl();
                String barcode;
                boolean sameBarcode = false;
                do {
                    if (userCoupon.getCoupon().getOid() == 3) {
                        barcode = uniqueCodeGenerator.generateCodeNumeric(10);
                        longBarcode = Long.parseLong(barcode);
                    } else if (userCoupon.getCoupon().getOid() == 4) {
                        barcode = uniqueCodeGenerator.generateCodeNumeric(11);
                        longBarcode = Long.parseLong(barcode);
                    } else {
                        barcode = uniqueCodeGenerator.generateCodeNumeric(12);
                        longBarcode = Long.parseLong(barcode);
                    }

                    //验证是否由重复条形码,增加服务器压力?
                    for (UserCoupon findSameBarcodeUserCoupon : userCouponRepository.findAll()) {
                        if (findSameBarcodeUserCoupon.getCouponBarcode() == longBarcode) {
                            sameBarcode = true;
                            break;
                        }
                    }

                } while (sameBarcode);
            }

            userCoupon.setCouponBarcode(longBarcode);

            userCoupon.setUid(uid);
            userCoupon.setEvent(eventOptional.get());

            userCoupon.setOccurTime(userCouponModel.getOccurTime());
            userCoupon.setSubmitTime(new Date());

            userCoupon.setStartTime(eventOptional.get().getStartTime());
            userCoupon.setEndTime(eventOptional.get().getEndTime());

            userCoupon.setUsed(Boolean.FALSE);

            //先把userCoupon存入数据库再取出来重新赋值给userCoupon.
            userCoupon = userCouponService.save(userCoupon).get();

            //把userCoupon的值转给userCouponModel.
            model = beanMapper.map(userCoupon, UserCouponModel.class);
        } else {
            /*
             if cannot hit one rule, return null to client?
             如果抽出的userCouponModel是空的model = null.
              */
            model = null;
        }
        //返回model.
        return model;
    }

    /**
     * 查询匹配openingCode和uid的userCoupon.
     *
     * @param openingCode target info.
     * @param uid         target info.
     * @return 值为userCouponModel的List实例.
     */
    @Override
    public List <UserCouponModel> findUserCoupon(@NotNull String openingCode, @NotNull String uid) {
        //查询匹配openingCode的event并赋值给eventOptional.
        Optional <Event> eventOptional = eventService.findByOpeningCode(openingCode);
        //如果eventOptional不存在,则进入下面语句块.
        if (!eventOptional.isPresent()) {
            //抛出一个带有说明的异常:通过openingCode没有找到event.
            throw new EventNotFoundException("cannot find event with opening code: " + openingCode);
        }
        //查询匹配event_oid, uid的userCoupon,并赋值给userCouponList.
        List <UserCoupon> userCouponList = userCouponQueryService.findUserCoupons(eventOptional.get().getOid(), uid);
        List <UserCouponModel> result = new ArrayList <>();
        //如果userCouponList的值存在,则进入下面语句.
        if (CollectionUtils.isNotEmpty(userCouponList)) {
            //把转换给UserCouponModel,并赋值给result.
            result = userCouponList.stream().map(e -> beanMapper.map(e, UserCouponModel.class)).collect(Collectors.toList());
        }
        //返回值为userCouponModel的List实例
        return result;
    }

    /**
     * 使用userCoupon
     *
     * @param userCouponModel target info.
     * @return 被使用的userCoupon的信息.
     */
    @Override
    public UserCouponModel doUseCoupon(@NotNull UserCouponModel userCouponModel) {
        //把传入的userCouponModel的oid赋值给couponOid.
        Long couponOid = userCouponModel.getOid();
        //把传入的userCouponModel的uid赋值给uid.
        String uid = userCouponModel.getUid();
        //如果uid和couponOid有一个不存在,或两个都不存在,则进入下面语句.
        if (couponOid == null || StringUtils.isBlank(uid)) {
            //抛出一个带有说明的异常:数据不足异常.
            throw new ParameterRequiredException("cannot use this coupon {user coupon oid is " + couponOid + " uid is " + uid);
        }
        //查询匹配couponOid的userCoupon并赋值给userCouponOptional.
        Optional <UserCoupon> userCouponOptional = userCouponService.findById(couponOid);
        //如果userCouponOptional不存在,则进入下面语句.
        if (!userCouponOptional.isPresent()) {
            //抛出一个带有说明的异常:通过couponOid找不到对应的userCoupon.
            throw new UserCouponNotFoundException("the user coupon is going to be used cannot be found: " + couponOid);
        }

        // validate biz
        //把userCouponOptional的值赋值给新声明的userCoupon
        UserCoupon userCoupon = userCouponOptional.get();
        //如果取出的userCoupon的uid和传入的uid不匹配,则进入下面语句.
        if (!StringUtils.equalsIgnoreCase(uid, userCoupon.getUid())) {
            //抛出一个带有说明的异常:不是查询用户的userCoupon异常.
            throw new NotYourCouponException("the user coupon is not belonged to you");
        }
        //如果userCoupon被使用了,则进入下面语句.
        if (userCoupon.getUsed()) {
            //抛出一个带有说明的异常:被使用异常.
            throw new UserCouponIsUsedException("the user coupon has been used already.");
        }
        //声明Date对象,并取得userCoupon的有效日期时间.
        Date now = new Date();
        Date startTime = userCoupon.getStartTime();
        Date endTime = userCoupon.getEndTime();
        //如果userCoupon的有效时间存在,则进入下面语句.
        if (startTime != null && endTime != null) {
            //如果兑奖日期还没到,则进入下面语句.
            if (!(now.after(startTime) && now.before(endTime))) {
                //抛出一个带有说明的异常:无效异常.
                throw new UserCouponExpiredException("the user coupon is expired or not in event period.");
            }
        } else {
            //抛出一个带有说明的异常:不可用异常.
            throw new InvalidUserCouponException("the user coupon is not valid because it have invalid start time or end time.");
        }

        // update coupon as used
        //设定userCoupon的属性uesd = true, used_uid, occurTime, submitTime并存入数据库再取出来赋值给userCoupon.
        userCoupon.setUsed(Boolean.TRUE);
        userCoupon.setUsedBy(uid);
        userCoupon.setUsedOccurTime(userCouponModel.getUsedOccurTime());
        userCoupon.setUsedSubmitTime(new Date());
        userCoupon = userCouponService.save(userCoupon).get();
        //把userCoupon的值转换成userCouponModel并赋值给modle.
        UserCouponModel model = beanMapper.map(userCoupon, UserCouponModel.class);
        //返回model.
        return model;
    }
}
