package com.example.ledger.service;

import com.example.ledger.enums.TransactionType;
import com.example.ledger.model.Transaction;
import com.example.ledger.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Handles business logic for {@link Transaction} related operations
 */
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public void createTransaction(final BigDecimal amount, final TransactionType type){
        final Transaction newTransaction = Transaction.builder()
                .amount(amount)
                .type(type)
                .date(Date.from(Instant.now()))
                .build();

        transactionRepository.save(newTransaction);
    }

    public List<Transaction> getAccountTransactionsHistory(){
        return transactionRepository.getTransactions()
                .stream()
                .sorted(Comparator.comparing(Transaction::getDate)).toList().reversed();
    }

    public void deleteTransactionsStartingOnDate(final Date sessionInitDate){
        transactionRepository.deleteTransactionsStartingOnDate(sessionInitDate);
    }
}
