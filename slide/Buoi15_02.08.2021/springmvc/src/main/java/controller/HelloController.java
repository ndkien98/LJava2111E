package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "index";  // Ten file JSP
    }

    @RequestMapping(value = "/hellolink", method = RequestMethod.GET)
    public String hello() {
        return "hello";  // Ten file JSP
    }

    @RequestMapping(value = "/googlelink", method = RequestMethod.GET)
    public String google() {
        return "google"; // Ten file JSP
    }

}
