package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private Key key;
    private final long expirationMillis = 60 * 60 * 1000; // 1 hour

    // REQUIRED by tests
    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    // REQUIRED by tests
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    // REQUIRED by tests
    public String generateTokenForUser(UserAccount user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    // REQUIRED by tests
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // REQUIRED by tests
    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    // REQUIRED by tests
    public String extractRole(String token) {
        return parseToken(token).get("role", String.class);
    }

    // REQUIRED by tests
    public Long extractUserId(String token) {
        return parseToken(token).get("userId", Long.class);
    }

    // REQUIRED by tests
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }
}
