/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.jpa.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * class description goes here.
 */
@Embeddable
@Setter
@Getter
public class Address {

    /* fields -------------------------------------------------------------- */

    @NotNull
    @Size(max = 100)
    private String addressLine1;

    @NotNull
    @Size(max = 100)
    private String addressLine2;

    @NotNull
    @Size(max = 100)
    private String city;

    @NotNull
    @Size(max = 100)
    private String state;

    @NotNull
    @Size(max = 100)
    private String country;

    @NotNull
    @Size(max = 6)
    private String zipCode;

    /* constructors -------------------------------------------------------- */

    public Address() {

    }

    public Address(String addressLine1, String addressLine2, String city,
                   String state, String country, String zipCode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    /* public methods ------------------------------------------------------ */

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}