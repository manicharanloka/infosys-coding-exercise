package com.example.rewardsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RewardsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewardsApiApplication.class, args);
    }

}
// Transactions has transactionid, customerid, money spent, dateoftransaction