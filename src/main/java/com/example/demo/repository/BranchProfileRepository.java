package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BranchProfile;

public interface BranchProfileRepository extends JpaRepository<BranchProfile, Long> {

    Optional<BranchProfile> findByBranchCode(String branchCode);
}
