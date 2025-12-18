package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class BranchProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String branchCode;
    private String branchName;
    private String contactEmail;
    private boolean active;
    private LocalDateTime lastSyncAt;
    @PrePersist
    public void onCreate() {
        lastSyncAt = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBranchCode() {
        return branchCode;
    }
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public LocalDateTime getLastSyncAt() {
        return lastSyncAt;
    }
    public void setLastSyncAt(LocalDateTime lastSyncAt) {
        this.lastSyncAt = lastSyncAt;
    }
}