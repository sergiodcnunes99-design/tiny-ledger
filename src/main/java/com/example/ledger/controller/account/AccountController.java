package com.example.ledger.controller.account;

import com.example.ledger.dto.outbound.BalanceResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//ASSUMPTION: I created the account domain only to handle the balance fetching, as balance is normally tied to an account
@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountControllerProcessor accountControllerProcessor;

    @Operation(description = "Returns the balance of the account")
    @ApiResponse(responseCode = "200", description = "Balance returned with success")
    @GetMapping(value = "/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceResponseDTO> getBalance(){
        return ResponseEntity.ok(accountControllerProcessor.getBalance());
    }
}
