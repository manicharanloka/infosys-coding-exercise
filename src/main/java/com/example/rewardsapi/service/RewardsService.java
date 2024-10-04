package com.example.rewardsapi.service;

import com.example.rewardsapi.entity.Transaction;
import com.example.rewardsapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardsService {
    @Autowired
    TransactionRepository transactionRepository;

    public Map<String, Object> calculateRewardPointsForMonth(Long customerId, LocalDateTime startDate, LocalDateTime endDate) {
        List<Transaction> transactionList = transactionRepository.findAllByCustomerIdAndDateOfTransactionBetween(customerId, startDate, endDate);
        if(transactionList.isEmpty()) return null;
        Map<String, Integer> monthlyPoints = new LinkedHashMap<>(); // for storing monthly points
        int totalPoints=0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yyyy");
        for(Transaction transaction: transactionList) {
            int points = calculatePoints(transaction.getAmount());
            totalPoints+=points;
            String month = transaction.getDateOfTransaction().format(formatter);
            monthlyPoints.merge(month, points, Integer::sum); // updates points
        }
        Map<String, Object> rewardsSummary = new LinkedHashMap<>(); // for storing monthly and total points
        rewardsSummary.put("monthlyPoints", monthlyPoints);
        rewardsSummary.put("totalPoints", totalPoints);
        return rewardsSummary;
    }

    private int calculatePoints(Double amount) {
        int points=0;
        amount-=50; // first 50 points earns 0 points
        if(amount>0){
            points+=(int) Math.min(50, amount); // points between 50 and 100 earn 1 point
            amount-=50;
        }
        if(amount>0) points+=(int) (amount*2); // points over 100 earn 2 points
        return points;
    }
}
