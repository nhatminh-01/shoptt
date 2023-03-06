package com.shoptt.controlleradmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryAdminController {

    @RequestMapping(value = {"/admin/category"}, method = RequestMethod.GET)
    public String homePage(){
        return "admin/category";
    }

    @RequestMapping(value = {"/admin/addcategory"}, method = RequestMethod.GET)
    public String addCategory(){
        return "admin/addcategory";
    }
}
