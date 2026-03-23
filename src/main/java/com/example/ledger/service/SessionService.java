package com.example.ledger.service;

import com.example.ledger.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public void createSession(){
        sessionRepository.getSession().initDate = Date.from(Instant.now());
    }

    public void commitSession(){
        sessionRepository.getSession().initDate = null;
    }

    public void rollbackSession(){
        sessionRepository.getSession().initDate = null;
    }

    public Date getSessionInitDate(){
        return sessionRepository.getSession().initDate;
    }
}
