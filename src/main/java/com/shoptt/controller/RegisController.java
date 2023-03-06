package com.shoptt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisController {

    @RequestMapping(value = {"/regis"}, method = RequestMethod.GET)
    public String homePage(){
        return "user/regis";
    }

    @RequestMapping(value = {"/forget"}, method = RequestMethod.GET)
    public String forgetPage(){
        return "user/remember";
    }
}
