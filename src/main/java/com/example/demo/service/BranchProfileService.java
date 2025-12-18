package com.example.demo.service;
import java.util.List;


import java.util.List;
import com.example.demo.entity.BranchProfileEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

public interface BranchProfileService {
    BranchProfileEntity createBranch(BranchProfileEntity branch);
    List<BranchProfileEntity> getAllBranches();
}
