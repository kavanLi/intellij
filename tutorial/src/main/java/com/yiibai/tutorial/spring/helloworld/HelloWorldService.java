/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.yiibai.tutorial.spring.helloworld;

/**
 * class description goes here.
 */
public class HelloWorldService {

    /* fields -------------------------------------------------------------- */

    private HelloWorld helloWorld;

    /* constructors -------------------------------------------------------- */

    public HelloWorldService() {
    }

    /* public methods ------------------------------------------------------ */

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}