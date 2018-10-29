package com.example.newlookonetoone.coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * class description goes here.
 */
@Repository
public interface CouponRepository extends JpaRepository <Coupon, Long> {

}
