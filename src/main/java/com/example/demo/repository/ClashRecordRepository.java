package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ClashRecord;

public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {

    List<ClashRecord> findByEventAIdOrEventBId(Long eventAId, Long eventBId);

    List<ClashRecord> findByResolvedFalse();
}
