package org.spring.mvc.controller;

import org.spring.mvc.entity.User;
import org.spring.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/register")
    public String signup() {
        return "register";
    }

    @RequestMapping(path="/createUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute User user, @RequestParam("fullName") String fn, Model model) {
        System.out.println("ФИО: " + fn);
        System.out.println(user);
        userService.registerUser(user);
//        model.addAttribute("msg", "Пользователь зарегистрирован успешно");
        model.addAttribute("user", user);
        return "success";
    }
}
