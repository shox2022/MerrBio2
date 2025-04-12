package com.example.JavaBio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // This should return a view name (e.g., index.html in the templates folder)
        return "index";
    }
}
