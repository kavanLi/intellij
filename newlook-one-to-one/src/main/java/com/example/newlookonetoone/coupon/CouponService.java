/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.newlookonetoone.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class description goes here.
 */
@Service
public class CouponService {

    /* fields -------------------------------------------------------------- */
    @Autowired
    private CouponRepository couponRepository;
    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */
    public void save(Coupon coupon) {
        couponRepository.save(coupon);
    }

    public void deleteById(Long id) {
        couponRepository.delete(id);
    }

    public void deleteAll() {
        couponRepository.deleteAll();
    }

    public String update(Coupon coupon) {
        if (0 != coupon.getId()) {
            couponRepository.save(coupon);
            return "成功";
        }
        return "失败";
    }

    public Coupon findById(Long id) {
        return couponRepository.findOne(id);
    }

    public String findAll() {
        //ArrayList<Coupon> couponArrayList = new ArrayList <Coupon>();
        return couponRepository.findAll().toString();
    }


    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}