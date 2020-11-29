package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

    public int num;
    public int randomize(){
        return (int)(Math.random()*(6-1+1)+1);
    }

//    @RequestMapping("/roll-dice")
//    @ResponseBody
//    public String diceRoll(){
//        return "guess a number one through six.";
//    }

    @GetMapping("/roll-dice")
    public String showJoinForm() {
        return "roll-dice";
    }

//    @PostMapping("/dice-roll")
//    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
//        model.addAttribute("cohort", "Welcome to " + cohort + "!");
//        return "join";
//    }

    @GetMapping("/roll-dice/{n}")
    public String sayHello(@PathVariable int n,Model model) {
        num = randomize();
        model.addAttribute("n", n);
        model.addAttribute("num", num);

        String message;
        if (n == num){
            message = "Correct";
        } else {
            message = "Incorrect";
        }
        model.addAttribute("rightOrWrong", message);

        return "roll-dice";
    }

}

//Create a page at /roll-dice that asks the user to guess a number. There should be links on this page for 1 through 6
// that should make a GET request to /roll-dice/n where n is the number guessed. This page should display a random number
// (the dice roll), the user's guess and a message based on whether or not they guessed the correct number.
//
//Bonus
//
//"Roll" a series of dice on each page load, as opposed to an individual die. Show all the rolls to the user and display
// how many rolls matched their guess.