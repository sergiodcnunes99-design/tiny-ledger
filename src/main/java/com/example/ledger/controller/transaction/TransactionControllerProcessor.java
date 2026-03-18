package com.example.ledger.controller.transaction;

import com.example.ledger.dto.inbound.TransactionRequestDTO;
import com.example.ledger.dto.outbound.TransactionResponseDTO;
import com.example.ledger.dto.outbound.TransactionHistoryResponseDTO;
import com.example.ledger.mapper.TransactionMapper;
import com.example.ledger.model.Transaction;
import com.example.ledger.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionControllerProcessor {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    void createTransaction(final TransactionRequestDTO transactionRequestDTO){
        transactionService.createTransaction(transactionRequestDTO.amount(), transactionRequestDTO.type());
    }

    TransactionHistoryResponseDTO getHistory(){
        final List<Transaction> transactions = transactionService.getAccountTransactionsHistory();
        final List<TransactionResponseDTO> transactionsDTOs = transactions.stream().map(transactionMapper::toDto).toList();

        return TransactionHistoryResponseDTO.builder().transactionsHistory(transactionsDTOs).build();
    }
}
