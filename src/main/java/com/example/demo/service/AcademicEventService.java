package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.EventMergeRecord;

import java.util.List;
import com.example.demo.entity.AcademicEventEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

public interface AcademicEventService {
    AcademicEventEntity createEvent(AcademicEventEntity event);
    List<AcademicEventEntity> getAllEvents();
}
