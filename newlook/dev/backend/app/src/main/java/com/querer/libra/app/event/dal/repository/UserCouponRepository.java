/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.dal.repository;

import java.util.Date;
import java.util.List;

import com.querer.libra.app.event.domain.entity.UserCoupon;
import com.querer.libra.platform.core.dal.repository.BaseRepository;

/**
 * UserCoupon repository.
 */
public interface UserCouponRepository extends BaseRepository <UserCoupon, Long> {

    /**
     * 找到匹配eventOid, uid的userCoupon.
     *
     * @param eventOid target info.
     * @param uid      target info.
     * @return target info.
     */
    List <UserCoupon> findByEventOidAndUid(Long eventOid, String uid);

    /**
     * 找到匹配uid, submitTime的userCoupon.
     *
     * @param uid       target info.
     * @param startDate target info.
     * @param endDate   target info.
     * @return 值为userCoupon的List实例.
     */
    List <UserCoupon> findByUidAndSubmitTimeBetween(String uid, Date startDate, Date endDate);

    /**
     * 统计匹配ruleOid, submitTime的userCoupon的数量.
     *
     * @param ruleOid   target info.
     * @param startDate target info.
     * @param endDate   target info.
     * @return Long型数据, 值为匹配的userCoupon的数量.
     */
    Long countByRuleOidAndSubmitTimeBetween(Long ruleOid, Date startDate, Date endDate);

    /**
     * 统计匹配couponOid, submitTime的userCoupon的数量.
     *
     * @param couponOid target info.
     * @param startDate target info.
     * @param endDate   target info.
     * @return Long型数据, 值为匹配的userCoupon的数量.
     */
    Long countByCouponOidAndSubmitTimeBetween(Long couponOid, Date startDate, Date endDate);
}
