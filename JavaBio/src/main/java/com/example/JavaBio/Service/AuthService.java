package com.example.JavaBio.Service;


import com.example.JavaBio.Entity.User;
import com.example.JavaBio.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String authenticateUser(String email, String password) {
        // 1. Find user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Validate password (plain text comparison - NOT SECURE, TEMPORARY)
        if (!user.getPasswordPlain().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        // 3. Return role if validation passes
        return user.getRole();
    }
}