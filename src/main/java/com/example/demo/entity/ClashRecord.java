package com.example.demo.entity;

import java.time.LocalDateTime;

public class ClashRecord {

    private long id;
    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String description;
    private LocalDateTime detectedAt;
    private boolean resolved;

    // REQUIRED no-arg constructor
    public ClashRecord() {}

    // REQUIRED constructor used by tests
    public ClashRecord(long id,
                       Long eventAId,
                       Long eventBId,
                       String clashType,
                       String severity,
                       String description,
                       LocalDateTime detectedAt,
                       boolean resolved) {
        this.id = id;
        this.eventAId = eventAId;
        this.eventBId = eventBId;
        this.clashType = clashType;
        this.severity = severity;
        this.description = description;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    // getters & setters REQUIRED BY TEST
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Long getEventAId() { return eventAId; }
    public void setEventAId(Long eventAId) { this.eventAId = eventAId; }

    public Long getEventBId() { return eventBId; }
    public void setEventBId(Long eventBId) { this.eventBId = eventBId; }

    public String getClashType() { return clashType; }
    public void setClashType(String clashType) { this.clashType = clashType; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
