package com.movieticket.booking.service;

import com.movieticket.booking.model.Booking;
import com.movieticket.booking.model.Movie;
import com.movieticket.booking.model.Seat;
import com.movieticket.booking.model.User;
import com.movieticket.booking.repository.BookingRepository;
import com.movieticket.booking.repository.MovieRepository;
import com.movieticket.booking.repository.SeatRepository;
import com.movieticket.booking.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private SeatRepository seatRepo;

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Booking bookSeat(Long userId, Long seatId, Long movieId) {
        // Ambil user
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User tidak ditemukan"));

        // Ambil seat
        Seat seat = seatRepo.findById(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat tidak ditemukan"));

        // Ambil movie
        Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie tidak ditemukan"));

        // Cek apakah seat sudah dipesan untuk movie tsb
        boolean exists = bookingRepo.existsBySeatAndMovie(seat, movie);
        if (exists) {
            throw new IllegalStateException("Seat sudah dipesan untuk movie ini");
        }

        // Buat booking baru
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSeat(seat);
        booking.setMovie(movie);
        booking.setBookingTime(LocalDateTime.now());

        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepo.findByUserId(userId);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        if (!bookingRepo.existsById(bookingId)) {
            throw new IllegalArgumentException("Booking tidak ditemukan");
        }
        bookingRepo.deleteById(bookingId);
    }
}
