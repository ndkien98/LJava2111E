package com.t3h.newspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeController {


    @GetMapping(value = {"/","index"})
    public String helloAE(Model model, @RequestParam(defaultValue = "") String name){
        model.addAttribute("name",name);
        return "hello";
    }



}
