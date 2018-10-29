/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package pers.kavan.www.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * class description goes here.
 */
@RestController
@RequestMapping(path = "/coupon")
public class CouponController {


    /* fields -------------------------------------------------------------- */
    @Autowired
    private CouponService couponService;

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */
    @PostMapping(path = "/add")
    public String save(@RequestBody Coupon coupon) {
        couponService.save(coupon);
        System.out.println("增");
        System.out.println(coupon);
        return "增";
    }

    @DeleteMapping(path = "/delete")
    public void deleteById(@RequestParam Long id) {
        couponService.deleteById(id);
        System.out.println("删");
    }

    @DeleteMapping(path = "/deleteAll")
    public void deleteAll() {
        couponService.deleteAll();
        System.out.println("删除所有");
    }

    @PutMapping(path = "/update")
    public String update(@RequestBody Coupon coupon) {
        System.out.println("改");
        return couponService.update(coupon);
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam Long id) {
        System.out.println("查");
        System.out.println(couponService.findById(id));
        return couponService.findById(id);
    }

    @GetMapping(path = "/findAll")
    public String find() {
        System.out.println("查找所有");
        System.out.println(couponService.findAll());
        return couponService.findAll();
    }
    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}