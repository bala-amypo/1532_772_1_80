package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEventEntity;
import com.example.demo.service.AcademicEventService;

@RestController
public class AcademicEventController {

    @Autowired
    private AcademicEventService eventService;

    @PostMapping("/addevent")
    public AcademicEventEntity add(@RequestBody AcademicEventEntity entity) {
        return eventService.createEvent(entity);
    }

    @GetMapping("/showevents")
    public List<AcademicEventEntity> show() {
        return eventService.getAllEvents();
    }
}
