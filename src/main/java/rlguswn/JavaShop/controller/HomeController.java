package rlguswn.JavaShop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        String message = "JavaShop API 프로젝트입니다.";
        return ResponseEntity.ok(message);
    }
}
