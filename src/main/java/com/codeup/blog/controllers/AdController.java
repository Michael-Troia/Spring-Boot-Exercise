package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdController {

    private final PostRepository adDao;

    public AdController(PostRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "Body content 1"));
        posts.add(new Post("Post 2", "Body content 2"));
        posts.add(new Post("Post 3", "Body content 3"));

        model.addAttribute("posts" , posts);
        return "posts/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model model){
        Post post = new Post("Post " + id, "Some cool stuff " + id + ".");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/ads/create")
    @ResponseBody
    public String showCreateForm(){
        return "view the form for creating a post";
    }

//    @PostMapping("/ads/create")
//    @ResponseBody
//    public String createAd(){
//        Ad ad = new Ad("title", "ps5");
//        Ad dbAd = adDao.save(ad);
//        return "create a new Ad with the id: " + dbAd.getId();
//    }


}