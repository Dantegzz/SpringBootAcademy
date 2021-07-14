package com.dann97.springboot.services;

import com.dann97.springboot.entity.User;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    void save(List<User> users);
}
