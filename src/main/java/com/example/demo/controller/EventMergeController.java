package com.example.demo.controller;

import com.example.demo.service.EventMergeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/event-merge")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    /**
     * Merge events across branches
     * Expected JSON:
     * {
     *   "eventIds": [1, 2, 3],
     *   "mergeReason": "Overlapping schedules"
     * }
     */
    @PostMapping("/merge")
    public ResponseEntity<String> mergeEvents(
            @RequestBody Map<String, Object> request) {

        // Extract eventIds
        List<?> rawIds = (List<?>) request.get("eventIds");
        List<Long> eventIds = new ArrayList<>();
        for (Object id : rawIds) {
            eventIds.add(Long.valueOf(id.toString()));
        }

        // Extract merge reason
        String mergeReason = request.get("mergeReason").toString();

        // Call service with CORRECT signature
        eventMergeService.mergeEvents(eventIds, mergeReason);

        return new ResponseEntity<>("Events merged successfully", HttpStatus.OK);
    }

    /**
     * Health check endpoint
     */
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Event Merge Service is running", HttpStatus.OK);
    }
}
