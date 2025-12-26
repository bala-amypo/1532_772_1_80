package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final AcademicEventRepository academicEventRepository;
    private final EventMergeRecordRepository eventMergeRecordRepository;

    public EventMergeServiceImpl(AcademicEventRepository academicEventRepository,
                                 EventMergeRecordRepository eventMergeRecordRepository) {
        this.academicEventRepository = academicEventRepository;
        this.eventMergeRecordRepository = eventMergeRecordRepository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        if (eventIds == null || eventIds.isEmpty()) {
            throw new ResourceNotFoundException("No events found to merge");
        }

        List<AcademicEvent> events = academicEventRepository.findAllById(eventIds);

        if (events.isEmpty()) {
            throw new ResourceNotFoundException("No events found to merge");
        }

        LocalDate start = events.stream()
                .map(AcademicEvent::getStartDate)
                .min(LocalDate::compareTo)
                .orElse(LocalDate.now());

        LocalDate end = events.stream()
                .map(AcademicEvent::getEndDate)
                .max(LocalDate::compareTo)
                .orElse(LocalDate.now());

        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(
                eventIds.stream().map(String::valueOf).reduce((a, b) -> a + "," + b).orElse("")
        );
        record.setMergedTitle("Merged Events");
        record.setMergedStartDate(start);
        record.setMergedEndDate(end);
        record.setMergeReason(reason);
        record.setCreatedAt(LocalDateTime.now());

        return eventMergeRecordRepository.save(record);
    }
}
