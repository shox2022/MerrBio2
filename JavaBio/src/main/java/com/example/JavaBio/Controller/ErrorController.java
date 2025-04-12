package com.example.JavaBio.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}
