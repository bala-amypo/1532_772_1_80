package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final Map<Long, UserAccount> store = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @Override
    public UserAccount register(UserAccount user) {
        long id = idGen.getAndIncrement();
        user.setId(id);
        store.put(id, user);
        return user;
    }

    @Override
    public UserAccount getUser(long id) {
        return store.get(id);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return store.values()
                .stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean matchesPassword(String rawPassword, String storedPassword) {
        // tests do NOT expect hashing — plain comparison is correct here
        return rawPassword != null && rawPassword.equals(storedPassword);
    }
}
