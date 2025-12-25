package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount findByEmail(String email);

    UserAccount save(UserAccount user);

    boolean matchesPassword(String rawPassword, String encodedPassword);
}
