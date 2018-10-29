/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package pers.kavan.www;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class description goes here.
 */
@RestController
public class HelloWorldController {

    /* fields -------------------------------------------------------------- */

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}