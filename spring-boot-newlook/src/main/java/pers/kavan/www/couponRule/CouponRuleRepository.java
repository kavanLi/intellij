package pers.kavan.www.couponRule;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class description goes here.
 */

public interface CouponRuleRepository extends CrudRepository <CouponRule, Long> {
}
