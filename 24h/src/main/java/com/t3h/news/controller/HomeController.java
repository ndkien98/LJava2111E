package com.t3h.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller : đánh dấu là 1 controller ( component)
 *  để spring tạo bean ( object ) trong spring container
 *
 *  HomeController home1 = new HomeController();
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(){
        return "/admin/index";
    }
}
