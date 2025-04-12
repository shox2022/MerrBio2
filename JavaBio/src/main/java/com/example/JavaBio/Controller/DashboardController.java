package com.example.JavaBio.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.JavaBio.Entity.User;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model,
                            @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "dashboard";
    }
}