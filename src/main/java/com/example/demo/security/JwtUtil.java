package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private Key key;
    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    @PostConstruct
    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    // --------------------------------------------------
    // TOKEN GENERATION
    // --------------------------------------------------
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(UserAccount user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("userId", user.getId());

        return generateToken(claims, user.getEmail());
    }

    // --------------------------------------------------
    // 🔥 TEST-COMPATIBLE TOKEN PARSER
    // --------------------------------------------------
    public JwtPayload parseToken(String token) {
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        return new JwtPayload(jws);
    }

    // --------------------------------------------------
    // HELPERS USED BY TESTS
    // --------------------------------------------------
    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    public String extractRole(String token) {
        return parseToken(token).getPayload().get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parseToken(token).getPayload().get("userId", Long.class);
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }

    // ==================================================
    // ✅ STATIC INNER CLASS (NO NEW FILE)
    // ==================================================
    public static class JwtPayload {

        private final Jws<Claims> jws;

        public JwtPayload(Jws<Claims> jws) {
            this.jws = jws;
        }

        // 🔥 THIS MAKES THE TEST PASS
        public Claims getPayload() {
            return jws.getBody();
        }
    }
}
