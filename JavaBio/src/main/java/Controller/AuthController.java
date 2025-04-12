package Controller;

import Entity.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String email,
            @RequestParam String password,
            RedirectAttributes redirectAttributes) {

        // Temporary validation
        if (email.isEmpty() || password.isEmpty()) {
            redirectAttributes.addAttribute("error", true);
            return "redirect:/login";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password,
            RedirectAttributes redirectAttributes) {

        // Temporary validation
        if (email.isEmpty() || password.isEmpty()) {
            return "redirect:/register";
        }

        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/login";
    }
}
