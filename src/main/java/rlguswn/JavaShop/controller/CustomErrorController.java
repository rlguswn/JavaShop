package rlguswn.JavaShop.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    @RequestMapping("/403")
    public String accessDenied(HttpServletRequest request, Model model) {
        model.addAttribute("message", "접근 권한이 없습니다.");
        model.addAttribute("prevPage", request.getHeader("Referer"));
        return "error/accessDenied";
    }
}
