package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @RequestMapping("/posts")
    @ResponseBody
    public String listPosts(){
        return "This is the list of posts.";
    }

    @RequestMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable int id){
        return "You are viewing post #" + id + " .";
    }

    @RequestMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "This is the form for creating blog posts.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String publishNewPost(){
        return "Your post has been posted!";
    }
}
//Create a PostController class. This controller should return strings for the following routes that describe what will ultimately be there.
//method	url	description
//GET	/posts	posts index page
//GET	/posts/{id}	view an individual post
//GET	/posts/create	view the form for creating a post
//POST	/posts/create	create a new post