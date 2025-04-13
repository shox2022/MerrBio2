package com.example.JavaBio.Controller;

import com.example.JavaBio.Entity.User;
import com.example.JavaBio.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/login")
    public String showLoginForm(
            @RequestParam(value = "error", required = false) String error,
            Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid credentials");
        }
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/login")
    public String processLogin(
            @RequestParam String email,
            @RequestParam String password,
            RedirectAttributes redirectAttributes) {

        User user = userRepository.findByEmailAndPassword(email, password)
                .orElse(null);

        if (user == null) {
            redirectAttributes.addAttribute("error", true);
            return "redirect:/login";
        }

        return "redirect:/" + user.getRole().toLowerCase() + "-dashboard?userId=" + user.getUserId();
    }

    @GetMapping("/consumer-dashboard")
    public String consumerDashboard(
            @RequestParam Long userId,
            Model model) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("user", user);
        return "consumer";
    }

    @GetMapping("/farmer-dashboard")
    public String farmerDashboard(
            @RequestParam Long userId,
            Model model) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("user", user);
        return "farmer";
    }


    @PostMapping("/register")
    public String processRegistration(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role,
            RedirectAttributes redirectAttributes) {

        if (email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "All fields are required");
            return "redirect:/register";
        }

        if (userRepository.findByEmail(email).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "Email already registered");
            return "redirect:/register";
        }

        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setEmail(email);
        newUser.setPasswordPlain(password);  // Fixed method name
        newUser.setRole(role.toLowerCase());

        userRepository.save(newUser);

        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/register";
    }
}