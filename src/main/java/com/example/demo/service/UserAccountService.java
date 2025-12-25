package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    // REQUIRED by AuthController
    UserAccount register(UserAccount user);

    UserAccount findByEmail(String email);

    UserAccount getUser(Long id);

    List<UserAccount> getAllUsers();
}
