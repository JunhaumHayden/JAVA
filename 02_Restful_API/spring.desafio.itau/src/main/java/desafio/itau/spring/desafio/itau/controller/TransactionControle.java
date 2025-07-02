package desafio.itau.spring.desafio.itau.controller;

import desafio.itau.spring.desafio.itau.dto.TransactionRequest;
import desafio.itau.spring.desafio.itau.model.Transaction;
import desafio.itau.spring.desafio.itau.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
class TransactionControle {
    private final TransactionService transactionService;

    public TransactionControle(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> creatTransaction(@Valid @RequestBody TransactionRequest request) {
        if (request.getDataHora().isAfter(OffsetDateTime.now())) {
            return ResponseEntity.unprocessableEntity().build();
        }
        TransactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
