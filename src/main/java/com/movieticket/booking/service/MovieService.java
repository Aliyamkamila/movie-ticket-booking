package com.movieticket.booking.service;

import com.movieticket.booking.model.Movie;
import com.movieticket.booking.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public Page<Movie> searchMovies(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return movieRepo.findByTitleContainingIgnoreCase(keyword, pageable);
    }
}
