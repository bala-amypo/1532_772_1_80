package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role;
    private String department;
    private LocalDateTime createdAt;

    public UserAccount() {}

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (role == null) role = "REVIEWER";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
