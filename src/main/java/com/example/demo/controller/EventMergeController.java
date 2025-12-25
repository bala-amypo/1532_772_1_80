package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService mergeService;

    public EventMergeController(EventMergeService mergeService) {
        this.mergeService = mergeService;
    }

    @PostMapping
    public EventMergeRecord merge(@RequestParam List<Long> eventIds,
                                  @RequestParam String reason) {
        return mergeService.mergeEvents(eventIds, reason);
    }

    @GetMapping("/{id}")
    public EventMergeRecord get(@PathVariable Long id) {
        return mergeService.getMergeRecordById(id);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return mergeService.getAllMergeRecords();
    }

    @GetMapping("/range")
    public List<EventMergeRecord> getByDate(@RequestParam LocalDate start,
                                            @RequestParam LocalDate end) {
        return mergeService.getMergeRecordsByDate(start, end);
    }
}
