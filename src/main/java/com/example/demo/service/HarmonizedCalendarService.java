package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.HarmonizedCalendar;

public interface HarmonizedCalendarService {

    HarmonizedCalendar generateHarmonizedCalendar(String title, String generatedBy);

    HarmonizedCalendar getCalendarById(Long id);

    List<HarmonizedCalendar> getAllCalendars();

    List<HarmonizedCalendar> getCalendarsWithinRange(LocalDate start, LocalDate end);
}
