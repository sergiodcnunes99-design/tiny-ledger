package com.example.ledger.repository;

import com.example.ledger.model.Session;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Getter
@Repository
@RequiredArgsConstructor
public class SessionRepository {
    private Session session = new Session();
}
