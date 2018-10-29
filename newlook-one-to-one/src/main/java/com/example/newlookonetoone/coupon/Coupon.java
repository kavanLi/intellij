/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.newlookonetoone.coupon;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * class description goes here.
 */

@Entity
@Table(name = "coupon")
@Setter
@Getter
public class Coupon implements Serializable {

    /* fields -------------------------------------------------------------- */
    //@Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    //@NotNull
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date date;

    /* constructors -------------------------------------------------------- */

    public Coupon() {
    }

    public Coupon(String name) {
        this.name = name;
    }

    /* public methods ------------------------------------------------------ */

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}