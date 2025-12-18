package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventMergeRecordController {

    private final EventMergeRecordService service;

    public EventMergeRecordController(EventMergeRecordService service) {
        this.service = service;
    }

    @PostMapping
    public EventMergeRecord save(@RequestBody EventMergeRecord r) {
        return service.save(r);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EventMergeRecord get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public EventMergeRecord update(@PathVariable Long id, @RequestBody EventMergeRecord r) {
        return service.update(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
