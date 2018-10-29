package com.gcbi.damo.cotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class HtmlController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String callback) {
        request.setAttribute("callback", callback);
        return "login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }


}
