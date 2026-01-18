package org.springboot.learnspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

//    @RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World");
        return "hello";
    }
}
