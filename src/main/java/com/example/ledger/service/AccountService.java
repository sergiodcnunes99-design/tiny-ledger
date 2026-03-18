package com.example.ledger.service;

import com.example.ledger.controller.account.AccountController;
import com.example.ledger.enums.TransactionType;
import com.example.ledger.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Handles business logic for "Account" related operations
 */
@Service
@RequiredArgsConstructor
public class AccountService {

    private final TransactionRepository transactionRepository;

    public BigDecimal getBalance(){
        //ASSUMPTION: For simplicity I created only one repository, for the transactions, and I assume the application
        //holds only one account, so all transactions in the transactionRepository belong to the "account".
        //I could have created a repository for the "Account" entity, but for simplicity purposes I will keep only one repository
        return transactionRepository.getTransactions().stream()
                .map(transaction ->
                        TransactionType.WITHDRAWAL == transaction.getType() ? transaction.getAmount().negate() : transaction.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
