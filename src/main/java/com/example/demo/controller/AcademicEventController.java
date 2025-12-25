package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService eventService;

    public AcademicEventController(AcademicEventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public AcademicEvent create(@RequestBody AcademicEvent event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public AcademicEvent update(@PathVariable Long id,
                                @RequestBody AcademicEvent event) {
        return eventService.updateEvent(id, event);
    }

    @GetMapping("/{id}")
    public AcademicEvent get(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/branch/{branchId}")
    public java.util.List<AcademicEvent> getByBranch(@PathVariable Long branchId) {
        return eventService.getEventsByBranch(branchId);
    }

    @GetMapping
    public java.util.List<AcademicEvent> getAll() {
        return eventService.getAllEvents();
    }
}
