package com.example.ledger.model;

import com.example.ledger.enums.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class Transaction {
    private BigDecimal amount;
    private TransactionType type;
    private Date date;
}
