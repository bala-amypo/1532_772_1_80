package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;

    private String mergedTitle;

    private LocalDate mergedStartDate;

    private LocalDate mergedEndDate;

    private String mergeReason;

    private LocalDateTime createdAt;

    // ✅ No-arg constructor (required by JPA)
    public EventMergeRecord() {
    }

    // ✅ All-args constructor (used in testcases)
    public EventMergeRecord(Long id,
                            String sourceEventIds,
                            String mergedTitle,
                            LocalDate mergedStartDate,
                            LocalDate mergedEndDate,
                            String mergeReason,
                            LocalDateTime createdAt) {
        this.id = id;
        this.sourceEventIds = sourceEventIds;
        this.mergedTitle = mergedTitle;
        this.mergedStartDate = mergedStartDate;
        this.mergedEndDate = mergedEndDate;
        this.mergeReason = mergeReason;
        this.createdAt = createdAt;
    }

    // ✅ Auto-generate createdAt (test expects this)
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getSourceEventIds() {
        return sourceEventIds;
    }

    public String getMergedTitle() {
        return mergedTitle;
    }

    public LocalDate getMergedStartDate() {
        return mergedStartDate;
    }

    public LocalDate getMergedEndDate() {
        return mergedEndDate;
    }

    public String getMergeReason() {
        return mergeReason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ===== SETTERS =====

    // 🔥 THIS FIXES ISSUE 3 (Test line ~695)
    public void setId(Long id) {
        this.id = id;
    }

    public void setSourceEventIds(String sourceEventIds) {
        this.sourceEventIds = sourceEventIds;
    }

    public void setMergedTitle(String mergedTitle) {
        this.mergedTitle = mergedTitle;
    }

    public void setMergedStartDate(LocalDate mergedStartDate) {
        this.mergedStartDate = mergedStartDate;
    }

    public void setMergedEndDate(LocalDate mergedEndDate) {
        this.mergedEndDate = mergedEndDate;
    }

    public void setMergeReason(String mergeReason) {
        this.mergeReason = mergeReason;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
