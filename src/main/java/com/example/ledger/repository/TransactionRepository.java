package com.example.ledger.repository;

import com.example.ledger.model.Transaction;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Handles persistence level operations for {@link Transaction}
 */
@Getter
@Repository
@RequiredArgsConstructor
public class TransactionRepository {

    private final List<Transaction> transactions;

    public void save(final Transaction transaction){
        transactions.add(transaction);
    }
}
