package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMergeRecordServiceImpl implements EventMergeRecordService {

    private final EventMergeRecordRepository repo;

    public EventMergeRecordServiceImpl(EventMergeRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public EventMergeRecord save(EventMergeRecord record) {
        return repo.save(record);
    }

    @Override
    public List<EventMergeRecord> getAll() {
        return repo.findAll();
    }

    @Override
    public EventMergeRecord getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public EventMergeRecord update(Long id, EventMergeRecord record) {
        record.setId(id);
        return repo.save(record);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
