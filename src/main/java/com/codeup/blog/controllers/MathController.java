package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping("add/{num1}/and/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2){
        return num1 + num2;
    }

    @RequestMapping("subtract/{num1}/and/{num2}")
    @ResponseBody
    public int subtract(@PathVariable int num1, @PathVariable int num2){
        return num1 - num2;
    }

    @RequestMapping("multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1, @PathVariable int num2){
        return num1 * num2;
    }

    @RequestMapping("divide/{num1}/and/{num2}")
    @ResponseBody
    public int divide(@PathVariable int num1, @PathVariable int num2){
        return num1 / num2;
    }
}


//This controller should listen for requests for several routes that correspond to basic arithmetic operations and produce the result of the arithmetic.
//Example
//
//url	response
///add/3/and/4	7
///subtract/3/from/10	7
///multiply/4/and/5	20
///divide/6/by/3	2