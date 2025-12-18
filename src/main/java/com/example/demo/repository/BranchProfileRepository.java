package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BranchProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchProfileRepository extends JpaRepository<BranchProfileEntity, Long> {
}
