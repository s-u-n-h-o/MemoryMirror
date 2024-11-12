package com.toyproject.memoryMirror.web.controller;

import com.toyproject.memoryMirror.domain.model.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage(Model model) {
        model.addAttribute("user", User.builder().build());
        return "login";
    }

    @GetMapping("/signupPage")
    public String signupPage(Model model) {
        model.addAttribute("user", User.builder().build());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/album")
    public String album(HttpSession httpSession, Model model) {
        model.addAttribute("albumDetails", httpSession.getAttribute("albumDetails"));
        model.addAttribute("albumInfo", httpSession.getAttribute("albumInfo"));
        return "album";
    }
}
