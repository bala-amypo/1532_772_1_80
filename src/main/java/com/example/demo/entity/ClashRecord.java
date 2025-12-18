package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String eventA;
    private String eventB;
    private String clashReason;

    public ClashRecord() {}

    public ClashRecord(long id, String eventA, String eventB, String clashReason) {
        this.id = id;
        this.eventA = eventA;
        this.eventB = eventB;
        this.clashReason = clashReason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventA() {
        return eventA;
    }

    public void setEventA(String eventA) {
        this.eventA = eventA;
    }

    public String getEventB() {
        return eventB;
    }

    public void setEventB(String eventB) {
        this.eventB = eventB;
    }

    public String getClashReason() {
        return clashReason;
    }

    public void setClashReason(String clashReason) {
        this.clashReason = clashReason;
    }
}
