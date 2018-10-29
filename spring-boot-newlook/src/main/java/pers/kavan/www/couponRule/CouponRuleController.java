/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package pers.kavan.www.couponRule;

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
@RequestMapping(path = "couponRule")
public class CouponRuleController {

    /* fields -------------------------------------------------------------- */
    @Autowired
    private CouponRuleService couponRuleService;
    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */
    @PostMapping(path = "/add")
    public void save(@RequestBody CouponRule couponRule) {
        couponRuleService.save(couponRule);
    }

    @DeleteMapping(path = "/delete")
    public void deleteById(@RequestParam Long id) {
        couponRuleService.deleteById(id);
    }

    @PutMapping(path = "/update")
    public String update(@RequestBody CouponRule couponRule) {
        return couponRuleService.update(couponRule);
    }

    @GetMapping(path = "get")
    public void get() {
        couponRuleService.findAll();
    }
    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}