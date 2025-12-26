package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    // already required by tests
    UserAccount register(UserAccount user);

    UserAccount getUser(long id);

    // required by AuthController
    UserAccount findByEmail(String email);

    boolean matchesPassword(String rawPassword, String storedPassword);
}
