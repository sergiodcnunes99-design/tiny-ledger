package com.example.ledger.dto.outbound;

import lombok.Builder;

import java.util.List;

@Builder
public record TransactionHistoryResponseDTO(List<TransactionResponseDTO> transactionsHistory) {}
