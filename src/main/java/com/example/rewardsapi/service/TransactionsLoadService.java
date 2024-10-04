package com.example.rewardsapi.service;

import com.example.rewardsapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.rewardsapi.entity.Transaction;
import java.time.LocalDateTime;

@Component
public class TransactionsLoadService implements CommandLineRunner {
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public void run(String... args) throws Exception {
        // Customer 1 transactions
        transactionRepository.save(new Transaction(1L, LocalDateTime.now().minusMonths(1), 120.0));  // 90 points
        transactionRepository.save(new Transaction(1L, LocalDateTime.now().minusMonths(1), 50.0));   // 0 points
        transactionRepository.save(new Transaction(1L, LocalDateTime.now().minusMonths(2), 110.0));  // 70 points
        transactionRepository.save(new Transaction(1L, LocalDateTime.now().minusMonths(2), 80.0));   // 30 points
        transactionRepository.save(new Transaction(1L, LocalDateTime.now().minusMonths(3).plusDays(1), 150.0));  // 150 points
        transactionRepository.save(new Transaction(1L, LocalDateTime.now().minusMonths(3).plusDays(1), 170.0));  // 190 points

        // Customer 2 transactions
        transactionRepository.save(new Transaction(2L, LocalDateTime.now().minusMonths(1), 200.0));  // 250 points
        transactionRepository.save(new Transaction(2L, LocalDateTime.now().minusMonths(2), 95.0));   // 45 points
        transactionRepository.save(new Transaction(2L, LocalDateTime.now().minusMonths(2), 180.0));   // 210 points
        transactionRepository.save(new Transaction(2L, LocalDateTime.now().minusMonths(3).plusDays(1), 60.0));   // 10 points
        transactionRepository.save(new Transaction(2L, LocalDateTime.now().minusMonths(3).plusDays(1), 40.0));   // 0 points

        // Customer 3 transactions
        transactionRepository.save(new Transaction(3L, LocalDateTime.now().minusMonths(1), 75.0));   // 25 points
        transactionRepository.save(new Transaction(3L, LocalDateTime.now().minusMonths(2), 105.0));  // 60 points
        transactionRepository.save(new Transaction(3L, LocalDateTime.now().minusMonths(3).plusDays(1), 120.0));  // 90 points
    }
}
