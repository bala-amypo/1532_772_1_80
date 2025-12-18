package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BranchProfileEntity;

public interface BranchProfileService {
    BranchProfileEntity createBranch(BranchProfileEntity branch);
    List<BranchProfileEntity> getAllBranches();
}
