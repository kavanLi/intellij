/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.jpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

/**
 * class description goes here.
 */
@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    /* fields -------------------------------------------------------------- */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Name name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Address address;


    /* constructors -------------------------------------------------------- */

    public User() {

    }

    public User(Name name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    /* public methods ------------------------------------------------------ */

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}