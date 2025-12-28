package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final AcademicEventRepository eventRepo;
    private final EventMergeRecordRepository mergeRepo;

    public EventMergeServiceImpl(
            AcademicEventRepository eventRepo,
            EventMergeRecordRepository mergeRepo
    ) {
        this.eventRepo = eventRepo;
        this.mergeRepo = mergeRepo;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        if (eventIds == null || eventIds.isEmpty()) {
            return null;
        }

        List<AcademicEvent> events = eventRepo.findAllById(eventIds);

        if (events.isEmpty()) {
            return null;
        }

        EventMergeRecord record = new EventMergeRecord();

        record.setSourceEventIds(
                events.stream()
                        .map(e -> e.getId().toString())
                        .collect(Collectors.joining(","))
        );

        record.setMergedTitle(events.get(0).getTitle());

        record.setMergedStartDate(
                events.stream()
                        .map(AcademicEvent::getStartDate)
                        .min(LocalDate::compareTo)
                        .orElse(null)
        );

        record.setMergedEndDate(
                events.stream()
                        .map(AcademicEvent::getEndDate)
                        .max(LocalDate::compareTo)
                        .orElse(null)
        );

        record.setMergeReason(reason);

        return mergeRepo.save(record);
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return mergeRepo.findById(id).orElse(null);
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(
            LocalDate startDate,
            LocalDate endDate
    ) {
        return mergeRepo.findByCreatedAtBetween(startDate, endDate);
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return mergeRepo.findAll();
    }
}
