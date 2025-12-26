package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventMergeRecord {

    private long id;
    private String sourceBranch;
    private String targetBranch;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private LocalDateTime mergedAt;

    public EventMergeRecord() {}

    // REQUIRED constructor
    public EventMergeRecord(long id,
                            String sourceBranch,
                            String targetBranch,
                            LocalDate startDate,
                            LocalDate endDate,
                            String status,
                            LocalDateTime mergedAt) {
        this.id = id;
        this.sourceBranch = sourceBranch;
        this.targetBranch = targetBranch;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.mergedAt = mergedAt;
    }

    // getters
    public long getId() { return id; }
    public String getSourceBranch() { return sourceBranch; }
    public String getTargetBranch() { return targetBranch; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public LocalDateTime getMergedAt() { return mergedAt; }
}
