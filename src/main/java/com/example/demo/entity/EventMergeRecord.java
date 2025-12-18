package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String sourceEvent;
    private String mergedEvent;
    private String status;

    public EventMergeRecord() {}

    public EventMergeRecord(long id, String sourceEvent, String mergedEvent, String status) {
        this.id = id;
        this.sourceEvent = sourceEvent;
        this.mergedEvent = mergedEvent;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSourceEvent() {
        return sourceEvent;
    }

    public void setSourceEvent(String sourceEvent) {
        this.sourceEvent = sourceEvent;
    }

    public String getMergedEvent() {
        return mergedEvent;
    }

    public void setMergedEvent(String mergedEvent) {
        this.mergedEvent = mergedEvent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
