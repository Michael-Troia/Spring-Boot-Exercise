package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String addOne(@PathVariable String name) {
        return "Hello from " + name;
    }

//    @GetMapping("/hello")//request
//    @ResponseBody//response
//    public String hello() {
//        return "Hello from Spring!";
//    }

    @GetMapping("/create-a-hello")
    @ResponseBody
    public String showCreatePage(){
        return "This is the create form";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String submitCreateForm(){
        return "ad has been saved!";
    }

    @GetMapping("/hello/{zipcode}")
    @ResponseBody
    public int getZipCode(@PathVariable int zipcode){
        return zipcode;
    }
}
