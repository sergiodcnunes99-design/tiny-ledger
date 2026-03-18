package com.example.ledger.mapper;

import com.example.ledger.dto.outbound.TransactionResponseDTO;
import com.example.ledger.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionResponseDTO toDto(Transaction transaction);
}
