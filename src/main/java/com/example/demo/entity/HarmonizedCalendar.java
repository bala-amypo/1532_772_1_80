package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HarmonizedCalendar {

    private long id;
    private String branch;
    private String academicYear;
    private LocalDateTime generatedAt;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public HarmonizedCalendar() {}

    // REQUIRED constructor
    public HarmonizedCalendar(long id,
                              String branch,
                              String academicYear,
                              LocalDateTime generatedAt,
                              LocalDate startDate,
                              LocalDate endDate,
                              String status) {
        this.id = id;
        this.branch = branch;
        this.academicYear = academicYear;
        this.generatedAt = generatedAt;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    // getters
    public long getId() { return id; }
    public String getBranch() { return branch; }
    public String getAcademicYear() { return academicYear; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }
}
