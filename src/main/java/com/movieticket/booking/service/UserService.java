package com.movieticket.booking.service;

import com.movieticket.booking.model.User;

public interface UserService {
    User register(User user);
    User login(String username, String password);
}
