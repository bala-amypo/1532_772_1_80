package com.example.demo.security;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtException;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Simple hardcoded secret (OK for academic / test projects)
    private String secretKey = "my-secret-key-1234567890";

    // 1 hour
    private final long expirationMillis = 60 * 60 * 1000;

    @PostConstruct
    public void initKey() {
        // Ensures key is initialized before usage
        if (this.secretKey == null || this.secretKey.isEmpty()) {
            this.secretKey = "default-secret-key";
        }
    }

    // Generate JWT
    public String generateToken(Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Validate token (throws exception if invalid)
    public Claims validateToken(String token) throws JwtException {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token) {
        return validateToken(token).getSubject();
    }

    public Long extractUserId(String token) {
        Object value = validateToken(token).get("userId");
        return value != null ? Long.valueOf(value.toString()) : null;
    }

    public String extractRole(String token) {
        Object value = validateToken(token).get("role");
        return value != null ? value.toString() : null;
    }
}
