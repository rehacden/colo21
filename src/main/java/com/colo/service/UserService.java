package com.colo.service;

import com.colo.data.users.User;

public interface UserService {

    void save(User user);
    User findByUsername(String emailAddress);
}
