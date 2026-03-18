package com.example.ledger.dto.outbound;

import com.example.ledger.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

public record TransactionResponseDTO(BigDecimal amount, TransactionType type, Date date) {}
