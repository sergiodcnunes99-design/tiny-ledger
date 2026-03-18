package com.example.ledger.controller.transaction;

import com.example.ledger.dto.inbound.TransactionRequestDTO;
import com.example.ledger.dto.outbound.TransactionHistoryResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionControllerProcessor transactionControllerProcessor;

    @Operation(description = "Creates a new transaction")
    @ApiResponse(responseCode = "201", description = "Transaction created")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTransaction(
            @Valid @RequestBody TransactionRequestDTO transactionRequestDTO){
        transactionControllerProcessor.createTransaction(transactionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //ASSUMPTION: for this endpoint a pagination strategy should be implemented, but I will ignore that for the sake of simplicity
    @Operation(description = "Returns the history of transactions")
    @ApiResponse(responseCode = "200", description = "Transactions history returned with success")
    @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionHistoryResponseDTO> getHistory(){
        return ResponseEntity.ok(transactionControllerProcessor.getHistory());
    }
}
