/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.newlookonetoone.userCoupon;

import java.util.Random;

import com.example.newlookonetoone.coupon.Coupon;
import com.example.newlookonetoone.coupon.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class description goes here.
 */
@Service
public class UserCouponService {

    /* fields -------------------------------------------------------------- */

    @Autowired
    private UserCouponRepository userCouponRepository;

    @Autowired
    private CouponService couponService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    public UserCoupon draw(Integer userId) {
        Long anTempNumber = Long.valueOf(new Random().nextInt(9) + 1);
        Long couponRandomNum = null;
        if (1 == anTempNumber) {
            couponRandomNum = Long.valueOf(1);
        }
        if (1 < anTempNumber && anTempNumber < 4) {
            couponRandomNum = Long.valueOf(2);
        }
        if (3 < anTempNumber && anTempNumber < 7) {
            couponRandomNum = Long.valueOf(3);
        }
        if (6 < anTempNumber && anTempNumber < 11) {
            couponRandomNum = Long.valueOf(4);
        }
        logger.debug("The couponRandomNum is:" + String.valueOf(couponRandomNum));

        Coupon couponName = couponService.findById(couponRandomNum);

        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setUserId(userId);
        userCoupon.setCouponName(couponName.getName());
        userCoupon.setEnabled(true);
        UserCoupon addUserCouponToRepo = this.add(userCoupon);

        return addUserCouponToRepo;
    }

    public UserCoupon add(UserCoupon userCoupon) {
        return userCouponRepository.save(userCoupon);
    }

    public UserCoupon update(Integer userId) {
        UserCoupon userCoupon = userCouponRepository.findUserCouponByUserId(userId);
        userCoupon.setEnabled(false);
        return userCouponRepository.save(userCoupon);
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}