package com.sveacms.services;

import com.sveacms.entities.User;
import com.sveacms.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addNew(User user) {
        user.setActive(true);
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public ArrayList<User> findAll() {
        return (ArrayList<User>) userRepository.findAll();
    }
}
