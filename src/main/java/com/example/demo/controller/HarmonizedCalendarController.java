package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @PostMapping("/generate")
    public HarmonizedCalendar generate(@RequestBody Map<String, String> request) {
        return harmonizedCalendarService.generateHarmonizedCalendar(
                request.get("title"),
                request.get("generatedBy")
        );
    }

    @GetMapping("/{id}")
    public HarmonizedCalendar getById(@PathVariable Long id) {
        return harmonizedCalendarService.getCalendarById(id);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAll() {
        return harmonizedCalendarService.getAllCalendars();
    }

    @GetMapping("/range")
    public List<HarmonizedCalendar> getByRange(@RequestParam LocalDate start,
                                               @RequestParam LocalDate end) {
        return harmonizedCalendarService.getCalendarsWithinRange(start, end);
    }
}
