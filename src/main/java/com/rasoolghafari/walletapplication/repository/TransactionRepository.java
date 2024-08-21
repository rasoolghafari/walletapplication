package com.rasoolghafari.walletapplication.repository;

import com.rasoolghafari.walletapplication.model.Transaction;
import com.rasoolghafari.walletapplication.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}