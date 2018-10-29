/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.maven;

import org.junit.Assert;
import org.junit.Test;

/**
 * class description goes here.
 */
public class HelloWorldTest {

    /* fields -------------------------------------------------------------- */

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */
    @Test
    public void testHello() {
        Assert.assertEquals("hello world!", new HelloWorld().sayHello());
    }
    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}