/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.jpa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

/**
 * class description goes here.
 */
@Entity
@Table(name = "employees")
public class Employee {

    /* fields -------------------------------------------------------------- */
    @EmbeddedId
    private EmployeeIdentity employeeIdentity;

    @NotNull
    private String name;

    @NotNull
    @Size(max = 100)
    @NaturalId
    private String email;

    @Size(max = 15)
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    /* constructors -------------------------------------------------------- */

    public Employee() {
    }

    public Employee(EmployeeIdentity employeeIdentity, String name, String email, String phoneNumber) {
        this.employeeIdentity = employeeIdentity;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /* public methods ------------------------------------------------------ */

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}