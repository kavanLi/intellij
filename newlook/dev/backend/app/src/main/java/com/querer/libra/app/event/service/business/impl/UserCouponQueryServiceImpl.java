/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service.business.impl;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querer.libra.app.event.dal.repository.UserCouponRepository;
import com.querer.libra.app.event.domain.entity.UserCoupon;
import com.querer.libra.app.event.service.business.UserCouponQueryService;
import com.querer.libra.app.event.util.DateTimeUtil;

/**
 * 实现接口UserCouponQueryService.
 */
//注解.
@Service
public class UserCouponQueryServiceImpl implements UserCouponQueryService {

    /**
     * fields.
     */

    /**
     * 声明一个UserCouponRepository接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     */
    @Autowired
    private UserCouponRepository userCouponRepository;

    /**
     * public methods.
     */

    /**
     * 覆盖方法,通过userCouponRepository的findByEventOidAndUid方法查询匹配eventOid和uid的 <br>
     * userCoupon,findByEventOidAndUid方法返回的是userCoupon.
     *
     * @param eventOid 目标eventOid.
     * @param uid      目标uid.
     * @return 返回值为userCoupon的List.
     */
    @Override
    public List <UserCoupon> findUserCoupons(@NotNull Long eventOid, @NotNull String uid) {
        return userCouponRepository.findByEventOidAndUid(eventOid, uid);
    }

    /**
     * 覆盖方法,通过userCouponRepository的findByUidAndSubmitTimeBetween方法查询匹配uid, startDate, endDate <br>
     * 的userCoupon,findByUidAndSubmitTimeBetween方法换回的是userCoupon.
     * 需要声明Date对象,调用DateTimeUtil的静态方法取得当天日期.
     *
     * @param uid 目标uid.
     * @return 值为userCoupon的List.
     */
    @Override
    public List <UserCoupon> findUserCouponsToday(@NotNull String uid) {
        Date now = new Date();
        Date startDate = DateTimeUtil.getStartOfDay(now);
        Date endDate = DateTimeUtil.getEndOfDay(now);
        return userCouponRepository.findByUidAndSubmitTimeBetween(uid, startDate, endDate);
    }

    /**
     * 覆盖方法,通过userCouponRepository的countByRuleOidAndSubmitTimeBetween方法统计userCoupon.
     *
     * @param ruleOid   目标ruleOid.
     * @param startDate 目标startDate.
     * @param endDate   目标endDate.
     * @return 数量.
     */
    @Override
    public Long countUserCouponsBetweenRange(@NotNull Long ruleOid, @NotNull Date startDate, @NotNull Date endDate) {
        return userCouponRepository.countByRuleOidAndSubmitTimeBetween(ruleOid, startDate, endDate);
    }

    /**
     * 覆盖方法,通过userCouponRepository的countUserCouponsBetweenRangea方法统计userCoupon.
     *
     * @param couponOid 目标couponOid.
     * @param startDate 目标startDate.
     * @param endDate   目标endDate.
     * @return 数量.
     */
    @Override
    public Long countUserCouponsBetweenRangea(@NotNull Long couponOid, @NotNull Date startDate, @NotNull Date endDate) {
        return userCouponRepository.countByCouponOidAndSubmitTimeBetween(couponOid, startDate, endDate);
    }

}
