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

    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationMillis = 60 * 60 * 1000; // 1 hour

    // ===================== TOKEN GENERATION =====================

    // Required by controllers & tests
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    // Required by tests (overloaded method)
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    // Required by tests
    public String generateTokenForUser(UserAccount user) {
        return generateToken(user.getId(), user.getEmail(), user.getRole());
    }

    // ===================== TOKEN PARSING =====================

    // Required by tests
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Required by tests
    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    // Required by JwtAuthenticationFilter
    public String extractEmail(String token) {
        return parseToken(token).getSubject();
    }

    // Required by JwtAuthenticationFilter
    public String extractRole(String token) {
        Object role = parseToken(token).get("role");
        return role != null ? role.toString() : null;
    }

    // Required by tests
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // ===================== HELPERS =====================

    private boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
