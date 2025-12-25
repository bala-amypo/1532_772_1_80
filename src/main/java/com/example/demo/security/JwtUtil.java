package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.*;

public class JwtUtil {

    private SecretKey secretKey;
    private final long EXPIRATION = 60 * 60 * 1000; // 1 hour

    // REQUIRED BY TEST
    public void initKey() {
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(Long userId, String email, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey)
                .compact();
    }

    // REQUIRED BY TEST
    public String generateTokenForUser(UserAccount user) {
        return generateToken(user.getId(), user.getEmail(), user.getRole());
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token) {
        return parseToken(token).getSubject();
    }

    public String extractUsername(String token) {
        return extractEmail(token);
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
        } catch (Exception e) {
            return false;
        }
    }
}
