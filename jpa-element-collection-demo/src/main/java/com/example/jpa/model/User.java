/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

/**
 * class description goes here.
 */
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    /* fields -------------------------------------------------------------- */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @ElementCollection
    @CollectionTable(name = "user_phone_numbers", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone_number")
    private Set <String> phoneNumbers = new HashSet <>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "user_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Set <Address> addresses = new HashSet <>();

    /* constructors -------------------------------------------------------- */

    public User() {

    }

    public User(String name, String email, Set <String> phoneNumbers, Set <Address> addresses) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
    }

    /* public methods ------------------------------------------------------ */

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}