package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        UserAccount user = userService.findByEmail(email);

        if (user == null || !userService.matchesPassword(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(Map.of("email", email), email);
    }
}
