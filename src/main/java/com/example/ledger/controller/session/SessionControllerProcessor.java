package com.example.ledger.controller.session;

import com.example.ledger.service.SessionService;
import com.example.ledger.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class SessionControllerProcessor {

    private final SessionService sessionService;
    private final TransactionService transactionService;

    public void createSession(){
        sessionService.createSession();
    }

    public void commitSession(){
        sessionService.commitSession();
    }

    public boolean rollbackSession(){
        Date sessionInitDate = sessionService.getSessionInitDate();
        if(sessionInitDate == null){
            return false;
        }
        transactionService.deleteTransactionsStartingOnDate(sessionInitDate);
        sessionService.rollbackSession();
        return true;
    }
}
