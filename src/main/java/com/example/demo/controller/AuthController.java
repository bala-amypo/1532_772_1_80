// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserAccountService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     private final UserAccountService userAccountService;
//     private final AuthenticationManager authenticationManager;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserAccountService userAccountService,
//                           AuthenticationManager authenticationManager,
//                           JwtUtil jwtUtil) {
//         this.userAccountService = userAccountService;
//         this.authenticationManager = authenticationManager;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<UserAccount> register(@RequestBody RegisterRequest request) {

//         UserAccount user = new UserAccount(
//                 null,
//                 request.getName(),
//                 request.getEmail(),
//                 request.getPassword(),
//                 request.getRole(),
//                 request.getDepartment(),
//                 null
//         );

//         UserAccount created = userAccountService.register(user);
//         return ResponseEntity.ok(created);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {

//         authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(
//                         request.getEmail(),
//                         request.getPassword()
//                 )
//         );

//         UserAccount user = userAccountService.getUserByEmail(request.getEmail());

//         // ✅ CORRECT TOKEN GENERATION
//         String token = jwtUtil.generateTokenForUser(user);

//         return ResponseEntity.ok(Map.of("token", token));
//     }
// }
