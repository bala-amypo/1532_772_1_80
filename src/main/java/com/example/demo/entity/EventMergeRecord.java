package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;
    private String date;
    private String owner;

    public EventMergeRecord() {}

    public EventMergeRecord(String eventName, String date, String owner) {
        this.eventName = eventName;
        this.date = date;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
}
