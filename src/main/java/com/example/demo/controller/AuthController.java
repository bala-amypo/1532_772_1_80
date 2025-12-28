// package com.example.demo.controller;

// import com.example.demo.dto.ApiResponse;
// import com.example.demo.dto.LoginRequest;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserAccountService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserAccountService userAccountService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(UserAccountService userAccountService,
//                           JwtUtil jwtUtil,
//                           PasswordEncoder passwordEncoder) {
//         this.userAccountService = userAccountService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @PostMapping("/login")
//     public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {

//         // ✅ FIXED METHOD NAME
//         UserAccount user = userAccountService.findByEmail(request.getEmail());

//         if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//             return new ResponseEntity<>(
//                     new ApiResponse(false, "Invalid credentials"),
//                     HttpStatus.UNAUTHORIZED
//             );
//         }

//         String token = jwtUtil.generateTokenForUser(user);

//         Map<String, Object> data = new HashMap<>();
//         data.put("token", token);
//         data.put("user", user);

//         return ResponseEntity.ok(new ApiResponse(true, "Login successful", data));
//     }
// }
