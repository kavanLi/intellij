/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querer.libra.app.event.dal.repository.UserCouponRepository;
import com.querer.libra.app.event.domain.entity.UserCoupon;
import com.querer.libra.app.event.service.atom.UserCouponService;

/**
 * 实现接口UserCouponService.
 */
@Service
public class UserCouponServiceImpl implements UserCouponService {

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
     * 覆盖save方法,通过userCouponRepository的softlySave方法来存入userCoupon对应的rule,softlySave方法. <br>
     * 返回的是optional.
     *
     * @param rule 抽出coupon的rule.
     * @return 值为UserCoupon的optional.
     */
    @Override
    public Optional <UserCoupon> save(@NotNull UserCoupon rule) {
        return userCouponRepository.softlySave(rule);
    }

    /**
     * 覆盖delete方法,通过userCouponRepository的delete方法老删除匹配oid的userCoupon.
     *
     * @param oid 目标oid.
     */
    @Override
    public void delete(@NotNull Long oid) {
        userCouponRepository.delete(oid);
    }

    /**
     * 覆盖findById方法,通过userCouponRepository的findOne方法来查询匹配oid的userCoupon,findOne. <br>
     * 方法返回的是userCoupon,需要转换.
     *
     * @param oid 目标oid.
     * @return 返回值为userCoupon的Optioanl.
     */
    @Override
    public Optional <UserCoupon> findById(@NotNull Long oid) {
        return Optional.ofNullable(userCouponRepository.findOne(oid));
    }
}
