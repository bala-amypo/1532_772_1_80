package com.example.demo.controller;

import com.example.demo.service.EventMergeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     */
    @PostMapping("/merge")
    public ResponseEntity<Map<String, Object>> mergeEvents(
            @RequestBody Map<String, Object> request) {

        Map<String, Object> response =
                eventMergeService.mergeEvents(request);

        return ResponseEntity.ok(response);
    }

    /**
     * Health/status endpoint (used by tests)
     */
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Event Merge Service is running",
                HttpStatus.OK);
    }
}
