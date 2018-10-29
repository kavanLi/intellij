/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.maven2;

import org.junit.Assert;
import org.junit.Test;

/**
 * class description goes here.
 */
public class SpeakTest {

    /* fields -------------------------------------------------------------- */

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */
    @Test
    public void testSayHi() {
        Assert.assertEquals("hello world!", new Speak().sayHi());
    }
    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}