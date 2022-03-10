package com.t3h.demospringsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping(value = {"/home","/"},method = RequestMethod.GET)
    public String homePage(){
        return "welcomePage";
    }

    @RequestMapping(value = {"/adminInfo"},method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal){

        User user = (User) ((Authentication) principal).getPrincipal();

        String strUser = "hello admin" + user.getUsername();
        model.addAttribute("userInfo",strUser);
        return "adminPage";
    }

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String login(){
        return "loginPage";
    }

    @RequestMapping(value = {"/userInfo"},method = RequestMethod.GET)
    public String userPage(Model model, Principal principal){

        User user = (User) ((Authentication) principal).getPrincipal();

        String strUser = "hello user" + user.getUsername();
        model.addAttribute("userInfo",strUser);
        return "userInfoPage";
    }

    @RequestMapping(value = {"/403"},method = RequestMethod.GET)
    public String accessDenied(){
        return "403Page";
    }


}
