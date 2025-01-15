package rlguswn.JavaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        String message = "JavaShop API 프로젝트입니다.";
        model.addAttribute("message", message);
        return "home";
    }
}
