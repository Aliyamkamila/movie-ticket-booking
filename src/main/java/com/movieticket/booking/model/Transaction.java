package com.movieticket.booking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieTitle;
    private int ticketCount;
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
