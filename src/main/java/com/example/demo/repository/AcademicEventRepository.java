package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AcademicEvent;

public interface AcademicEventRepository extends JpaRepository<AcademicEvent, Long> {

    List<AcademicEvent> findByBranchId(Long branchId);

    List<AcademicEvent> findByEventType(String eventType);

    List<AcademicEvent> findByStartDateBetween(LocalDate start, LocalDate end);
}
