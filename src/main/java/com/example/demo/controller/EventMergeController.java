package com.example.demo.controller;

import com.example.demo.dto.EventMergeRequest;
import com.example.demo.dto.EventMergeResponse;
import com.example.demo.service.EventMergeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<EventMergeResponse> mergeEvents(
            @RequestBody EventMergeRequest request) {

        EventMergeResponse response = eventMergeService.mergeEvents(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Fetch merge history
     */
    @GetMapping("/history")
    public ResponseEntity<List<EventMergeResponse>> getMergeHistory() {

        List<EventMergeResponse> history =
                eventMergeService.getMergeHistory();

        return ResponseEntity.ok(history);
    }

    /**
     * Health check endpoint (used by tests)
     */
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Event Merge Service is running",
                HttpStatus.OK);
    }
}
