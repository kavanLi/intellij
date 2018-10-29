/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.jpa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


/**
 * class description goes here.
 */
@Embeddable
public class EmployeeIdentity implements Serializable {

    /* fields -------------------------------------------------------------- */
    @NotNull
    private String employeeId;

    @NotNull
    private String companyId;

    /* constructors -------------------------------------------------------- */

    public EmployeeIdentity() {
    }

    public EmployeeIdentity(String employeeId, String companyId) {
        this.employeeId = employeeId;
        this.companyId = companyId;
    }

    /* public methods ------------------------------------------------------ */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeIdentity that = (EmployeeIdentity) o;

        if (!employeeId.equals(that.employeeId)) return false;
        return companyId.equals(that.companyId);
    }

    @Override
    public int hashCode() {
        int result = employeeId.hashCode();
        result = 31 * result + companyId.hashCode();
        return result;
    }
}

/* private methods ----------------------------------------------------- */

/* getters/setters ----------------------------------------------------- */
