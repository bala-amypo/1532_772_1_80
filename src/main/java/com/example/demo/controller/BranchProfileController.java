package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService branchService;

    public BranchProfileController(BranchProfileService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public BranchProfile createBranch(@RequestBody BranchProfile branch) {
        return branchService.createBranch(branch);
    }

    @PutMapping("/{id}/status")
    public BranchProfile updateStatus(@PathVariable Long id,
                                      @RequestParam boolean active) {
        return branchService.updateBranchStatus(id, active);
    }

    @GetMapping("/{id}")
    public BranchProfile getBranch(@PathVariable Long id) {
        return branchService.getBranchById(id);
    }

    @GetMapping
    public java.util.List<BranchProfile> getAll() {
        return branchService.getAllBranches();
    }

    @GetMapping("/lookup/{code}")
    public BranchProfile getByCode(@PathVariable String code) {
        return branchService.findByBranchCode(code);
    }
}
