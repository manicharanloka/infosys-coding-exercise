package com.example.rewardsapi.controller;

import com.example.rewardsapi.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
    @Autowired
    RewardsService rewardsService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Map<String, Object>> getRewardsForCustomer(@PathVariable Long customerId) {
        Map<String, Object> rewardsSummary = rewardsService.calculateRewardPointsForMonth(customerId, LocalDateTime.now().minusMonths(3), LocalDateTime.now());
        return new ResponseEntity<>(rewardsSummary, HttpStatus.OK);
    }
}
