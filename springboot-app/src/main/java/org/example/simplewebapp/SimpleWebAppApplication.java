package org.example.simplewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SimpleWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleWebAppApplication.class, args);
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "🚀 Hello from My Spring Boot Web App");
        model.addAttribute("message", "✅ You've successfully customized a Java Spring Boot project with HTML, CSS, and Bootstrap!");
        return "index";
    }
}
