package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello/{name}")
    public String welcome(@PathVariable String name, Model model) {
        model.addAttribute("name",name);
        return "/hello";
    }

    @GetMapping("/hello")//request
    public String hello() {
        return "hello";
    }
//
//    @GetMapping("/create-a-hello")
//    @ResponseBody
//    public String showCreatePage(){
//        return "This is the create form";
//    }
//
////    @GetMapping("/hello")
////    @ResponseBody
////    public String submitCreateForm(){
////        return "ad has been saved!";
////    }
//
//    @GetMapping("/hello/{zipcode}")
//    @ResponseBody
//    public int getZipCode(@PathVariable int zipcode){
//        return zipcode;
//    }
}
