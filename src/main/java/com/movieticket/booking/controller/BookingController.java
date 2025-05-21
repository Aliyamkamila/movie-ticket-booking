package com.movieticket.booking.controller;

import com.movieticket.booking.model.Booking;
import com.movieticket.booking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> bookSeat(@RequestParam Long userId,
                                      @RequestParam Long seatId,
                                      @RequestParam Long movieId) {
        try {
            Booking booking = bookingService.bookSeat(userId, seatId, movieId);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable Long userId) {
        return bookingService.getUserBookings(userId);
    }
}
