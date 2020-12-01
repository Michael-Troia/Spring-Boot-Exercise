package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PostController{

    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "Some cool stuff 1."));
        posts.add(new Post("Post 2", "Some cool stuff 2."));
        posts.add(new Post("Post 3", "Some cool stuff 3."));

        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        Post post = new Post("Post " + id, "Some cool stuff " + id + ".");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreateForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost(){
        //... create a Post and save DB
        return "create a new post";
    }
//    @GetMapping("posts")
//    public String index(Model model){
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post("post1", "body content 1"));
//        posts.add(new Post("post2", "body content 2"));
//        model.addAttribute("posts",posts);
//
//        return "/posts/index";
//    }
//
//    @GetMapping("posts/{id}")
//    public String viewPost(@PathVariable int id, Model model){
//        Post post = new Post("post" + id, "body content " + id);
//        model.addAttribute("post", post);
//        return "/posts/show";
//    }
//
//    @RequestMapping("/posts/create")
//    @ResponseBody
//    public String createPostForm(){
//        return "This is the form for creating blog posts.";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String publishNewPost(){
//        return "Your post has been posted!";
//    }
}
//Create a PostController class. This controller should return strings for the following routes that describe what will ultimately be there.
//method	url	description
//GET	/posts	posts index page
//GET	/posts/{id}	view an individual post
//GET	/posts/create	view the form for creating a post
//POST	/posts/create	create a new post