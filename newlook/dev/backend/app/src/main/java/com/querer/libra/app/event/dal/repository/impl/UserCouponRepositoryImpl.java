/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.dal.repository.impl;

import java.util.List;

import com.querydsl.core.BooleanBuilder;

import com.querer.libra.app.event.dal.repository.UserCouponRepositoryCustom;
import com.querer.libra.app.event.domain.entity.QUserCoupon;
import com.querer.libra.app.event.domain.entity.UserCoupon;
import com.querer.libra.platform.core.dal.repository.BaseAbstractRepository;
import com.querer.libra.platform.core.util.querydsl.PredicateUtil;

public class UserCouponRepositoryImpl extends BaseAbstractRepository implements UserCouponRepositoryCustom {

    /* public methods ------------------------------------------------------ */

    @Override
    public List <UserCoupon> findByEventOidAndUid(Long eventOid, String uid) {
        QUserCoupon userCoupon = QUserCoupon.userCoupon;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder
                .and(PredicateUtil.eq(userCoupon.event.oid, eventOid))
                .and(PredicateUtil.eq(userCoupon.uid, uid));

        List <UserCoupon> result = getJPQLQueryFactory()
                .selectFrom(userCoupon)
                .where(booleanBuilder)
                .fetch();

        return result;
    }
}
