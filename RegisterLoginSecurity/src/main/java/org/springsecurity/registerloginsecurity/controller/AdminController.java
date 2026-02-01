package org.springsecurity.registerloginsecurity.controller;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springsecurity.registerloginsecurity.entity.Category;
import org.springsecurity.registerloginsecurity.entity.Post;
import org.springsecurity.registerloginsecurity.entity.User;
import org.springsecurity.registerloginsecurity.repository.UserRepo;
import org.springsecurity.registerloginsecurity.service.ICategoryService;
import org.springsecurity.registerloginsecurity.service.IPostService;
import org.thymeleaf.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IPostService postService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String email = principal.getName();
        User user = userRepo.findByEmail(email);
        model.addAttribute("user", user);
        return "admin/profile";
    }

    @GetMapping("/")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/loadAddItem")
    public String loadAddItem(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "admin/add_item";
    }

    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, HttpSession session) {
        Boolean existCategory = categoryService.existCategory(category.getName());
        if (existCategory) {
            session.setAttribute("errorMsg", "Category Name Already Exist");
        } else {
            Category savedCategory = categoryService.saveCategory(category);
            if (StringUtil.isNullOrEmpty(savedCategory.getName())) {
                session.setAttribute("errorMsg", "Category Save Failed");
            } else {
                session.setAttribute("sucMsg", "Saved Category Successfully");
            }
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id, HttpSession session) {
        Boolean deleteCategory = categoryService.deleteCategory(id);
        if (deleteCategory) {
            session.setAttribute("sucMsg", "Category Deleted Successfully");
        } else {
            session.setAttribute("errorMsg", "Category Delete Failed");
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/loadEditCategory/{id}")
    public String loadEditCategory(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "admin/edit_category";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute Category category, HttpSession session) {
        Category oldCategory = categoryService.getCategoryById(category.getId());
        if (oldCategory != null) {
            oldCategory.setName(category.getName());
        }
        Category updateCategory = categoryService.saveCategory(oldCategory);
        if (!StringUtil.isNullOrEmpty(updateCategory.getName())) {
            session.setAttribute("sucMsg", "Category Update Successfully");
        } else {
            session.setAttribute("errorMsg", "Category Update Failed");
        }
        return "redirect:/admin/category";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute Post post, HttpSession session, @RequestParam("file") MultipartFile image) throws IOException {

        String imageName = image.isEmpty() ? "default.jpg" : image.getOriginalFilename();
        post.setImage(imageName);

        Post savedPost = postService.savePost(post);

        if (!StringUtil.isNullOrEmpty(savedPost.getImage())) {
            String saveFile = new File("src/main/resources/static/img").getAbsolutePath();
            if (!image.isEmpty()) {
                Path path = Paths.get(saveFile + File.separator + "post_img" + File.separator + image.getOriginalFilename());
//                System.out.println(path);
                Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }
            session.setAttribute("sucMsg", "Post Saved Successfully");
        } else {
            session.setAttribute("errorMsg", "Post Save Failed");
        }

        return "redirect:/admin/loadAddItem";
    }

    @GetMapping("/items")
    public String loadViewPost(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "admin/items";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id, HttpSession session) {
        Boolean deleteItem = postService.deletePost(id);
        if (deleteItem) {
            session.setAttribute("sucMsg", "Category Deleted Successfully");
        } else {
            session.setAttribute("errorMsg", "Category Delete Failed");
        }
        return "redirect:/admin/items";
    }

    @GetMapping("/editItem/{id}")
    public String editItem(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("categories", categoryService.getAllCategory());
        return "admin/edit_items";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Post post, HttpSession session, @RequestParam("file") MultipartFile image) throws IOException {
        Post updateProduct = postService.updatePost(post, image);
        if (StringUtil.isNullOrEmpty(updateProduct.getImage())) {
            session.setAttribute("sucMsg", "Post Update Successfully");
        } else {
            session.setAttribute("errorMsg", "Post Update Failed");
        }
        return "redirect:/admin/editItem/" + post.getId();
    }
}
