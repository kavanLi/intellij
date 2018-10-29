/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package pers.kavan.www.couponRule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class description goes here.
 */
@Service
public class CouponRuleService {

    /* fields -------------------------------------------------------------- */
    @Autowired
    CouponRuleRepository couponRuleRepository;
    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */
    public void save(CouponRule couponRule) {
        couponRuleRepository.save(couponRule);
    }

    public void deleteById(Long id) {
        couponRuleRepository.delete(id);
    }

    public String update(CouponRule couponRule) {
        if (couponRule.getId() != 0) {
            couponRuleRepository.save(couponRule);
            return "success";
        }
        return "fail";
    }

    public void findAll() {
        couponRuleRepository.findAll();
    }


    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}