package org.springsecurity.registerloginsecurity.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springsecurity.registerloginsecurity.entity.Category;
import org.springsecurity.registerloginsecurity.entity.Post;
import org.springsecurity.registerloginsecurity.entity.User;
import org.springsecurity.registerloginsecurity.repository.UserRepo;
import org.springsecurity.registerloginsecurity.service.ICategoryService;
import org.springsecurity.registerloginsecurity.service.IPostService;
import org.springsecurity.registerloginsecurity.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @ModelAttribute
    public void commonUser(Principal principal, Model model) {
        if(principal != null) {
            String email = principal.getName();
            User user = userRepo.findByEmail(email);
            model.addAttribute("user", user);
        }
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "category", defaultValue = "") String category) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);

        List<Post> posts = postService.getAllSelectPosts(category);
        model.addAttribute("posts", posts);
        model.addAttribute("paramValue", category);
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }



    @GetMapping("/user/home")
    public String home() {
        return "home";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession session) {
//        System.out.println(user);
        User u = userService.saveUser(user);
        if (u != null) {
//            System.out.println("Save user success");
            session.setAttribute("msg", "Register successfully");
        } else{
//            System.out.println("Error save user");
            session.setAttribute("msg", "Register failed");
        }
        return "redirect:/register";
    }

    @GetMapping("/item/{id}")
    public String item(@PathVariable int id, Model model) {
        Post postById = postService.getPostById(id);
        model.addAttribute("post", postById);
        return "view_item";
    }
}
