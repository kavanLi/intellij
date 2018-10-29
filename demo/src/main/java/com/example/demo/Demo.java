/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.OptionalInt;

import javassist.expr.Instanceof;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

/**
 * class description goes here.
 */
public class Demo {

    /* fields -------------------------------------------------------------- */

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    public static void main(String[] args) {
        String[] list = {"ma", "cao", "yuab"};
        String foo = "sfasfdfs";
        String bar = "sfasfdfs";
        String baz = new String("sfasfdfs");
        System.out.println(baz == bar);
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}

@ToString(includeFieldNames = true, exclude = {"id", "dept"})
@Getter
@Setter
class Employee {
    private int id;
    private String name;
    private String email;
    private String dept;
}