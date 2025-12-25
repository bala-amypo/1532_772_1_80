package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository mergeRepo;
    private final AcademicEventRepository eventRepo;

    public EventMergeServiceImpl(EventMergeRecordRepository mergeRepo,
                                 AcademicEventRepository eventRepo) {
        this.mergeRepo = mergeRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        List<AcademicEvent> events = eventIds.stream()
                .map(id -> eventRepo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Event not found")))
                .collect(Collectors.toList());

        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(eventIds.toString());
        record.setMergedTitle("Merged Event");
        record.setMergedStartDate(events.get(0).getStartDate());
        record.setMergedEndDate(events.get(events.size() - 1).getEndDate());
        record.setMergeReason(reason);

        return mergeRepo.save(record);
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return mergeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merge record not found"));
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return mergeRepo.findAll();
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return mergeRepo.findByMergedStartDateBetween(start, end);
    }
}
