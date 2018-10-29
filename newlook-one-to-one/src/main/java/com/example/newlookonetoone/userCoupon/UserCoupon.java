/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.newlookonetoone.userCoupon;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * class description goes here.
 */
@Entity
@Table(name = "user_coupon")
@Setter
@Getter
public class UserCoupon implements Serializable {

    /* fields -------------------------------------------------------------- */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer userId;

    @NotNull
    private String couponName;

    @NotNull
    private Boolean enabled;

    /* constructors -------------------------------------------------------- */

    public UserCoupon() {
    }

    public UserCoupon(Integer userId, String couponName, Boolean enabled) {
        this.userId = userId;
        this.couponName = couponName;
        this.enabled = enabled;
    }

    /* public methods ------------------------------------------------------ */

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}