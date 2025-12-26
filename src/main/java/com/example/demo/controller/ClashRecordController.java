package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashDetectionService;

    public ClashRecordController(ClashDetectionService clashDetectionService) {
        this.clashDetectionService = clashDetectionService;
    }

    @PostMapping
    public ClashRecord log(@RequestBody ClashRecord clash) {
        return clashDetectionService.logClash(clash);
    }

    @PutMapping("/{id}/resolve")
    public ClashRecord resolve(@PathVariable Long id) {
        return clashDetectionService.resolveClash(id);
    }

    @GetMapping("/event/{eventId}")
    public List<ClashRecord> getForEvent(@PathVariable Long eventId) {
        return clashDetectionService.getClashesForEvent(eventId);
    }

    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolved() {
        return clashDetectionService.getUnresolvedClashes();
    }

    @GetMapping
    public List<ClashRecord> getAll() {
        return clashDetectionService.getAllClashes();
    }
}
