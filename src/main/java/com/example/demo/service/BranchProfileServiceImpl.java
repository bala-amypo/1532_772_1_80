package com.example.demo.service;

import java.util.List;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BranchProfileEntity;
import com.example.demo.repository.BranchProfileRepository;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    @Autowired
    private BranchProfileRepository branchRepo;

    @Override
    public BranchProfileEntity createBranch(BranchProfileEntity branch) {
        return branchRepo.save(branch);
    }

    @Override
    public List<BranchProfileEntity> getAllBranches() {
        return branchRepo.findAll();
    }
}
