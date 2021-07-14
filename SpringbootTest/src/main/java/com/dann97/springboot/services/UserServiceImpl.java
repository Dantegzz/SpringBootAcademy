package com.dann97.springboot.services;

import com.dann97.springboot.entity.User;
import com.dann97.springboot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String MESSAGE_USER_NOT_FOUND = "An error has occurred";
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {


        return userRepository.findMyUserByEmail(email).orElseThrow(() -> new RuntimeException(MESSAGE_USER_NOT_FOUND));

    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.findByNameContaining(name);
    }


    @Transactional
    public void save(List<User> users) {
        users.stream()
                .peek(user -> logger.info("Insert: " + user))
                .forEach(user -> userRepository.save(user));
    }
}
