package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashService;

    public ClashRecordController(ClashDetectionService clashService) {
        this.clashService = clashService;
    }

    @PostMapping
    public ClashRecord log(@RequestBody ClashRecord clash) {
        return clashService.logClash(clash);
    }

    @PutMapping("/{id}/resolve")
    public ClashRecord resolve(@PathVariable Long id) {
        return clashService.resolveClash(id);
    }

    @GetMapping("/event/{eventId}")
    public java.util.List<ClashRecord> getForEvent(@PathVariable Long eventId) {
        return clashService.getClashesForEvent(eventId);
    }

    @GetMapping("/unresolved")
    public java.util.List<ClashRecord> unresolved() {
        return clashService.getUnresolvedClashes();
    }

    @GetMapping
    public java.util.List<ClashRecord> getAll() {
        return clashService.getAllClashes();
    }
}
