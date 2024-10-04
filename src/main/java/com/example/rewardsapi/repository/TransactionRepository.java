package com.example.rewardsapi.repository;

import com.example.rewardsapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByCustomerIdAndDateOfTransactionBetween(Long customerId, LocalDateTime startDate, LocalDateTime endTime);
}
