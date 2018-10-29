package pers.kavan.www.coupon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * class description goes here.
 */
@Repository
public interface CouponRepository extends CrudRepository <Coupon, Long> {

}
