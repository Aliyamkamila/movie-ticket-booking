package com.movieticket.booking.service;

import com.movieticket.booking.model.Booking;
import java.util.List;

public interface BookingService {
    Booking bookSeat(Long userId, Long seatId, Long movieId);
    List<Booking> getUserBookings(Long userId);
    void cancelBooking(Long bookingId);
}
