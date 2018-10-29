/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querer.libra.app.event.domain.model.UserCouponModel;
import com.querer.libra.app.event.service.business.UserCouponBizService;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    /**
     * fields.
     */

    @Autowired
    private UserCouponBizService userCouponBizService;

    /**
     * public methods.
     */

    @RequestMapping(value = "/draw", method = RequestMethod.POST)
    public UserCouponModel postDrawCoupon(@RequestBody UserCouponModel userCouponModel) {
        return userCouponBizService.doDrawCoupon(userCouponModel);
    }

    @RequestMapping(value = "/{openingCode}", method = RequestMethod.GET)
    public List <UserCouponModel> getQueryUserCoupon(@PathVariable String openingCode, @RequestParam(value = "uid") String uid) {
        return userCouponBizService.findUserCoupon(openingCode, uid);
    }

    @RequestMapping(value = "/use", method = RequestMethod.PUT)
    public UserCouponModel putUseCoupon(@RequestBody UserCouponModel userCouponModel) {
        return userCouponBizService.doUseCoupon(userCouponModel);
    }

}