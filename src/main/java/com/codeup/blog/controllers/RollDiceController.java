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



    @GetMapping("/roll-dice")//url that will be accessed
    public String showJoinForm() {
        return "roll-dice";// reference to roll-dice.html template
    }

    @GetMapping("/roll-dice/{n}")
    public String sayHello(@PathVariable int n,Model model) {
        num = randomize();
        model.addAttribute("n", n);
        model.addAttribute("num", num);
//      model.addAttribute("Correct", n == num); todo also works as the below code to compare
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