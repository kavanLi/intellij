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
public class Name {

    /* fields -------------------------------------------------------------- */

    @NotNull
    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String middleName;

    @Size(max = 40)
    private String lastName;

    /* constructors -------------------------------------------------------- */

    public Name() {

    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /* public methods ------------------------------------------------------ */

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}