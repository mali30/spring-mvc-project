package com.mohamedali.springmvc.springmvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // tells spring mvc which view we want to return
    // mapped to the root
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
