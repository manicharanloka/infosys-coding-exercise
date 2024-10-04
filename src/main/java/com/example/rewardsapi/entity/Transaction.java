package com.example.rewardsapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long customerId;
    private LocalDateTime dateOfTransaction;
    private Double amount;

    public Transaction(){}
    public Transaction(Long customerId, LocalDateTime dateOfTransaction, double amount) {
        this.customerId = customerId;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
    }

    public Transaction(Long id, Long customerId, LocalDateTime dateOfTransaction, double amount) {
        this(customerId, dateOfTransaction, amount);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
