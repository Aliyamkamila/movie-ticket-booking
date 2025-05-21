package com.movieticket.booking.controller;

import com.movieticket.booking.model.Transaction;
import com.movieticket.booking.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction tx, @RequestParam Long userId) {
        Transaction created = transactionService.create(tx, userId);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Transaction>> userTx(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getUserTransactions(id));
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Transaction>> adminView() {
        return ResponseEntity.ok(transactionService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody Transaction tx) {
        Transaction updated = transactionService.update(id, tx);
        return ResponseEntity.ok(updated);
    }
}
