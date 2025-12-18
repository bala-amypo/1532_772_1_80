package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BranchProfileEntity;
import com.example.demo.service.BranchProfileService;

@RestController
public class BranchProfileController {

    @Autowired
    private BranchProfileService branchService;

    @PostMapping("/addbranch")
    public BranchProfileEntity add(@RequestBody BranchProfileEntity entity) {
        return branchService.createBranch(entity);
    }

    @GetMapping("/showbranches")
    public List<BranchProfileEntity> show() {
        return branchService.getAllBranches();
    }
}
