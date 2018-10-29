/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.yiibai.tutorial.spring;

import com.yiibai.tutorial.spring.helloworld.HelloWorld;
import com.yiibai.tutorial.spring.helloworld.HelloWorldService;
import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * class description goes here.
 */
public class HelloProgram {

    /* fields -------------------------------------------------------------- */

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");

        HelloWorld hw = service.getHelloWorld();

        hw.sayHello();
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}