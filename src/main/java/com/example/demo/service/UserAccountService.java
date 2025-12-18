package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    List<UserAccount> getAllUsers();
    UserAccount createUser(UserAccount user);
}
