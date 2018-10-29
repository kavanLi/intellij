/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.newlookonetoone.userCoupon;

import com.example.newlookonetoone.coupon.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * class description goes here.
 */
@RestController
@RequestMapping(path = "/newlook")
public class UserCouponController {

    /* fields -------------------------------------------------------------- */

    @Autowired
    private UserCouponService userCouponService;

    @Autowired
    private CouponService couponService;

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    @PostMapping(path = "/userCoupon")
    public UserCoupon drawALottery(@RequestParam Integer userId) {
        return userCouponService.draw(userId);
    }

    @PutMapping(path = "/userCoupon")
    public UserCoupon useCoupon(@RequestParam Integer userId) {
        return userCouponService.update(userId);
    }
    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}