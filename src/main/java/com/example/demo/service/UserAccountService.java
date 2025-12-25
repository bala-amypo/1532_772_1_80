package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    // CREATE
    UserAccount saveUser(UserAccount user);

    // READ
    List<UserAccount> getAllUsers();

    UserAccount getUser(Long id);

    UserAccount findByEmail(String email);
}
