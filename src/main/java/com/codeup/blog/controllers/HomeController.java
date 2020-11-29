package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String landingPageGreeting(){
        return "This is the landing page!";
    }

    @GetMapping("/home")//returns a path to the template file
    public String welcome(){
        return "/home";
    }

    @GetMapping("/join")
    public String showJoinForm(Model model){
        List<String> cohortNames = new ArrayList<>();
        cohortNames.add("COBOL");
        cohortNames.add("Draco");

        model.addAttribute("cohortNames", cohortNames);
        return "/join";
    }

    @PostMapping("/join") //todo instructs what to do when a post request from /join comes through
    public String postJoinForm(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", "Welcome to " + cohort);
        return "/join";
    }
}
