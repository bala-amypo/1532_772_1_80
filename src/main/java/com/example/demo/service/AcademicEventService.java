package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AcademicEventEntity;

public interface AcademicEventService {
    AcademicEventEntity createEvent(AcademicEventEntity event);
    List<AcademicEventEntity> getAllEvents();
}
