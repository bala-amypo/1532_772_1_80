package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEventEntity;
import com.example.demo.repository.AcademicEventRepository;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    @Autowired
    private AcademicEventRepository eventRepo;

    @Override
    public AcademicEventEntity createEvent(AcademicEventEntity event) {
        return eventRepo.save(event);
    }

    @Override
    public List<AcademicEventEntity> getAllEvents() {
        return eventRepo.findAll();
    }
}
