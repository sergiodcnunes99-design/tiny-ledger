package com.example.ledger.controller.account;

import com.example.ledger.dto.outbound.BalanceResponseDTO;
import com.example.ledger.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountControllerProcessor {

    private final AccountService accountService;

    BalanceResponseDTO getBalance(){
        return new BalanceResponseDTO(accountService.getBalance());
    }
}
