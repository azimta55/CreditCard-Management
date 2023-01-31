package com.CreditCard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CreditCard.Model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
