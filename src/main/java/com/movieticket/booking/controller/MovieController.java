package com.movieticket.booking.controller;

import com.movieticket.booking.model.Movie;
import com.movieticket.booking.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/search")
    public Page<Movie> search(
            @RequestParam String keyword,
            @RequestParam int page,
            @RequestParam int size
    ) {
        return movieService.searchMovies(keyword, page, size);
    }
}
