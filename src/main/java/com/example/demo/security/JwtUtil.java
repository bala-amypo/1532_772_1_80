package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component   // ⭐ THIS IS THE KEY FIX
public class JwtUtil {

    private SecretKey key;
    private final long expirationMillis = 1000 * 60 * 60; // 1 hour

    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    private SecretKey getKey() {
        if (key == null) {
            initKey();
        }
        return key;
    }

    // ---- Required by tests ----

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(getKey())
                .compact();
    }

    public String generateTokenForUser(UserAccount user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        return generateToken(claims, user.getEmail());
    }

    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    public String extractEmail(String token) {
        return parseToken(token).get("email", String.class);
    }

    public Long extractUserId(String token) {
        return parseToken(token).get("userId", Long.class);
    }

    public String extractRole(String token) {
        return parseToken(token).get("role", String.class);
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username)
                && parseToken(token).getExpiration().after(new Date());
    }
}
