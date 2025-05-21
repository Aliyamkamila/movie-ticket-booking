// BookingRepository.java
package com.movieticket.booking.repository;

import com.movieticket.booking.model.Booking;
import com.movieticket.booking.model.Movie;
import com.movieticket.booking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsBySeatAndMovie(Seat seat, Movie movie);
    List<Booking> findByUserId(Long userId);
}
