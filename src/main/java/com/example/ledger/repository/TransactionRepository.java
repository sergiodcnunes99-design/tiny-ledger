package com.example.ledger.repository;

import com.example.ledger.model.Transaction;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles persistence level operations for {@link Transaction}
 */
@Getter
@Repository
@RequiredArgsConstructor
public class TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>();

    public void save(final Transaction transaction){
        transactions.add(transaction);
    }

    public void deleteTransactionsStartingOnDate(final Date startDate){
        this.transactions = transactions.stream().filter(t -> t.getDate().before(startDate)).collect(Collectors.toList());
    }
}
