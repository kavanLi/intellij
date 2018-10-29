/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.thymeleaftour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * class description goes here.
 */
@Controller
public class HomeController {

    /* fields -------------------------------------------------------------- */

    public static final String appName = "ThymeleafTour";

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(value = "name", required = false,
                               defaultValue = "Guest") String name) {
        // We’re adding the name and title attributes to the Model
        // so that they can be accessed from the template.
        model.addAttribute("name", name);
        model.addAttribute("title", appName);
        //Finally, we’re returning the template name
        // which will be used to render the response to the browser.
        return "home";
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}