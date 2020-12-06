package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repos.PostRepository;
import com.codeup.blog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    //gets all the posts and puts it on the /posts page
    @GetMapping("/posts")
    public String index(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    //displays one post
    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post postFromDb = postDao.getOne(id);
        model.addAttribute("post", postFromDb);
        return "posts/show";
    }

    //shows posts/new.html when visiting posts/create
    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/new";
    }


    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post post

    ) {
        User user = userDao.getOne(1L);//todo needs to be dynamically set
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    //view edit form
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }


    //when the edit form is sent
    @PostMapping("/posts/{id}/edit")
    public String submitEdit(@ModelAttribute Post postToBeUpdated,
                             @PathVariable long id// is passed in from the PostMapping URL
    ) {
        postToBeUpdated.setOwner(userDao.getOne(1L));//todo needs to be dynamically set
        postToBeUpdated.setId(id);
        postDao.save(postToBeUpdated); //built-in thymeleaf

        return "redirect:/posts/" + postToBeUpdated.getId();
    }


    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }
}