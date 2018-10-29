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

import com.querer.libra.app.event.dal.repository.CouponRepository;
import com.querer.libra.app.event.domain.entity.Coupon;
import com.querer.libra.app.event.service.atom.CouponService;

/**
 * 实现接口CouponService.
 */
//注解.
@Service
public class CouonServiceImpl implements CouponService {

    /**
     * fields.
     */

    /**
     * 声明一个CouponRepository接口类型的引用变量,并自动装配,可以直接调用实现该接口的类中覆盖的方法.
     * 纠正,CouponRepository时一个接口,而下面调用的是父类接口的方法.
     */
    @Autowired
    private CouponRepository couponRepository;

    /**
     * public methods.
     */

    /**
     * 覆盖save方法,把coupon对象(softlySave)存入couponRepository,softlySave方法返回的值就是Optional类型的.
     *
     * @param coupon 传入coupon对象.
     * @return 返回值为event对象的optional实例.
     */
    @Override
    public Optional <Coupon> save(@NotNull Coupon coupon) {
        return couponRepository.softlySave(coupon);
    }

    /**
     * 覆盖delete方法,把oid参数传给couponRepository的delete方法,删除该匹配该oid的信息.
     *
     * @param oid 目标oid.
     */
    @Override
    public void delete(@NotNull Long oid) {
        couponRepository.delete(oid);
    }

    /**
     * 覆盖findById方法,把oid参数传给couponRepository的findOne方法,查询该匹配该oid的coupon. <br>
     * findById方法返回的是一个coupon对象,需要转换.
     *
     * @param oid 目标oid.
     * @return 返回值为coupon对象的optional实例.
     */
    @Override
    public Optional <Coupon> findById(@org.jetbrains.annotations.NotNull Long oid) {
        return Optional.ofNullable(couponRepository.findOne(oid));
    }
}
