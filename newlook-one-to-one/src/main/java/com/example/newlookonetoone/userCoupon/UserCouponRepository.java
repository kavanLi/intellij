package com.example.newlookonetoone.userCoupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * class description goes here.
 */
@Repository
public interface UserCouponRepository extends JpaRepository <UserCoupon, Long> {

    UserCoupon findUserCouponByUserId(Integer userId);
}
