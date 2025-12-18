package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;
import java.util.List;

public interface EventMergeRecordService {
    EventMergeRecord save(EventMergeRecord record);
    List<EventMergeRecord> getAll();
    EventMergeRecord getById(Long id);
    EventMergeRecord update(Long id, EventMergeRecord record);
    void delete(Long id);
}
