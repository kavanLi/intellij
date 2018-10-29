/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.demo;

import java.util.Date;

import lombok.Data;

/**
 * class description goes here.
 */
@Data
public class User implements Cloneable {

    /* fields -------------------------------------------------------------- */

    public String id;
    public String name;
    Date date;
    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}