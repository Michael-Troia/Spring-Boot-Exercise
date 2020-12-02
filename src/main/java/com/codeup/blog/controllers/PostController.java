package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PostController{

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

//    @GetMapping("/posts")
//    public String index(Model model) {
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post("Post 1", "Some cool stuff 1."));
//        posts.add(new Post("Post 2", "Some cool stuff 2."));
//        posts.add(new Post("Post 3", "Some cool stuff 3."));
//
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }

    //gets all the posts and puts it on the /posts page
    @GetMapping("/posts")
    public String index(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    //displays one post
    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
//        Post post = new Post("Post " + id, "Some cool stuff " + id + ".");
        Post postFromDb = postDao.getOne(id);
        model.addAttribute("post", postFromDb);
        return "posts/show";
    }

    //shows posts/new.html when visiting posts/create
    @GetMapping("/posts/create")
    public String showCreateForm(){
        return "posts/new";
    }


    @PostMapping("/posts/create")
    public String submitPost(
        @RequestParam(name = "title") String title,
        @RequestParam(name = "body") String body
    ){
        Post post = new Post(title, body);
        post = postDao.save(post);
        return "posts/index";
    }

    //view edit form
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }


    //when the edit form is sent
    @PostMapping("/posts/{id}/edit")
//    @ResponseBody
    public String submitEdit(
            @PathVariable long id, // is passed in from the PostMapping URL
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Post dbPost = postDao.getOne(id);
        dbPost.setTitle(title);
        dbPost.setBody(body);
        postDao.save(dbPost); //built-in thymeleaf

        return "redirect:/posts/" + dbPost.getId();
    }




//    public interface AdRepository extends JpaRepository<Post, Long> {
//        Post findByTitle(String title); // select * from ads where title = ?
//        Post findFirstByTitle(String title); // select * from ads where title = ? limit 1
//    }



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