package com.movieticket.booking.service;

import com.movieticket.booking.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction create(Transaction t, Long userId);
    List<Transaction> getUserTransactions(Long userId);
    List<Transaction> getAll();
    void delete(Long id);
    Transaction update(Long id, Transaction newData);
}
