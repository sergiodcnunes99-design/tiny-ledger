package com.example.ledger.controller.session;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
@RequiredArgsConstructor
public class SessionController {

    private final SessionControllerProcessor sessionControllerProcessor;

    @PostMapping()
    public ResponseEntity<Void> createSession(){
        sessionControllerProcessor.createSession();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/commit")
    public ResponseEntity<Void> commitSession(){
        sessionControllerProcessor.commitSession();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/rollback")
    public ResponseEntity<Void> rollbackSession(){
        boolean success = sessionControllerProcessor.rollbackSession();
        return success ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
