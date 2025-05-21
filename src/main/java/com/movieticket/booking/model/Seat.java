package com.movieticket.booking.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)  // Tambahkan anotasi @Column
    private String seatNumber;

    @Column(nullable = false)  // Tambahkan anotasi @Column
    private Boolean isBooked = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}