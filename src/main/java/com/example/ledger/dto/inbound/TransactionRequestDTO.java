package com.example.ledger.dto.inbound;

import com.example.ledger.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionRequestDTO(
        @NotNull(message = "Transaction amount is required")
        @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
        @Schema(description = "The transaction amount", defaultValue = "0.0")
        BigDecimal amount,

        @NotNull(message = "Transaction type is required")
        @Schema(description = "The type of the transaction", defaultValue = "DEPOSIT")
        TransactionType type
) {}
