package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtException;

import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private SecretKey secretKey;
    private final long expirationMillis = 1000 * 60 * 60; // 1 hour

    // REQUIRED by tests
    public void initKey() {
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    /* -------------------------------------------------
       TOKEN GENERATION
    ------------------------------------------------- */

    public String generateToken(Long userId, String email, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(secretKey)
                .compact();
    }

    // REQUIRED by tests
    public String generateTokenForUser(com.example.demo.entity.UserAccount user) {
        return generateToken(user.getId(), user.getEmail(), user.getRole());
    }

    /* -------------------------------------------------
       TOKEN PARSING
    ------------------------------------------------- */

    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)   // ✅ OLD + STABLE API
                .parseClaimsJws(token)
                .getBody();
    }

    /* -------------------------------------------------
       EXTRA HELPERS REQUIRED BY TESTS
    ------------------------------------------------- */

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    public Long extractUserId(String token) {
        Object val = parseToken(token).get("userId");
        return val == null ? null : Long.valueOf(val.toString());
    }

    public String extractRole(String token) {
        Object val = parseToken(token).get("role");
        return val == null ? null : val.toString();
    }

    public boolean isTokenValid(String token, String username) {
        try {
            Claims claims = parseToken(token);
            return claims.getSubject().equals(username)
                    && claims.getExpiration().after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
