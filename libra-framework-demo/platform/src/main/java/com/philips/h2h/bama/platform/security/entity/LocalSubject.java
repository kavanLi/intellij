/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.security.entity;

import javax.persistence.Transient;

/**
 * A sample case in local storage of subject.
 * <p>
 * It separates that subject info and detail user principal/credential info.
 * Authentication info like principal and credential is designed in Account;
 * Authorization info and organization are kept in Subject. All these data are
 * stored in local datasource only. When data is loaded from datasource
 * successfully, this LocalSubject should have sufficient the authentication and
 * authorization info fulfilled.
 */
// Uncomment below JPA annotations to init this entity into database
// @Entity
// @Table(name = "T_SEC_LOCAL_SUBJECT")
public class LocalSubject extends Subject {

    /* fields ------------------------------------------------------ */

    // Detail user principal/credential info in this field.
    private Account account;

    /* constructors ------------------------------------------------------ */

    public LocalSubject() {
    }

    public LocalSubject(Account account) {
        this.account = account;
    }

    /* public methods ------------------------------------------------------ */

    @Override
    @Transient
    public Object getPrincipals() {
        if (account != null) {
            this.account.getPrincipals();
        }
        return null;
    }

    @Override
    @Transient
    public Object getCredentials() {
        if (account != null) {
            this.account.getCredentials();
        }
        return null;
    }

    /* getters/setters ------------------------------------------------------ */

    // @OneToOne
    // @Cascade({org.hibernate.annotations.CascadeType.ALL})
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
