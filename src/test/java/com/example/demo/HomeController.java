package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<h1>✅ Jenkins Build Successful!</h1><p>Your Spring Boot app is running on port 9090.</p>";
    }
}
