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
        transactionRepository.save(new Transaction(1L, LocalDateTime.now().minusMonths(1), 120.0));
        transactionRepository.save(new Transaction(2L, LocalDateTime.now().minusMonths(2), 200.0));
    }
}
