package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private SecretKey key;
    private final long expirationMillis = 60 * 60 * 1000;

    // ===== REQUIRED BY TEST =====
    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    // ===== TOKEN GENERATION =====
    public String generateToken(Long userId, String email, String role) {
        if (key == null) initKey();

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        if (key == null) initKey();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(UserAccount user) {
        return generateToken(user.getId(), user.getEmail(), user.getRole());
    }

    // ===== TOKEN PARSING =====
    public Claims parseToken(String token) {
        if (key == null) initKey();

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload(); // <-- REQUIRED BY TEST
    }

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    public String extractEmail(String token) {
        return extractUsername(token);
    }

    public String extractRole(String token) {
        Object role = parseToken(token).get("role");
        return role != null ? role.toString() : null;
    }

    // ===== REQUIRED BY TEST =====
    public Long extractUserId(String token) {
        Object id = parseToken(token).get("userId");
        return id != null ? Long.parseLong(id.toString()) : null;
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username)
                && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
