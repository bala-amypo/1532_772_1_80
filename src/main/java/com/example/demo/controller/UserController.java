package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserAccountService service;

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user){
        return service.saveUser(user);
    }

    @GetMapping
    public List<UserAccount> getAll(){
        return service.getAllUsers();
    }
}
