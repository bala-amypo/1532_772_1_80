package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository eventMergeRecordRepository;
    private final AcademicEventRepository academicEventRepository;

    public EventMergeServiceImpl(EventMergeRecordRepository eventMergeRecordRepository,
                                 AcademicEventRepository academicEventRepository) {
        this.eventMergeRecordRepository = eventMergeRecordRepository;
        this.academicEventRepository = academicEventRepository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        List<AcademicEvent> events = eventIds.stream()
                .map(id -> academicEventRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Event not found")))
                .collect(Collectors.toList());

        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(
                eventIds.stream().map(String::valueOf).collect(Collectors.joining(","))
        );
        record.setMergedTitle("Merged Events");
        record.setMergedStartDate(
                events.stream().map(AcademicEvent::getStartDate).min(LocalDate::compareTo).orElse(null)
        );
        record.setMergedEndDate(
                events.stream().map(AcademicEvent::getEndDate).max(LocalDate::compareTo).orElse(null)
        );
        record.setMergeReason(reason);

        return eventMergeRecordRepository.save(record);
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return eventMergeRecordRepository.findAll();
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return eventMergeRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merge record not found"));
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return eventMergeRecordRepository.findByMergedStartDateBetween(start, end);
    }
}
