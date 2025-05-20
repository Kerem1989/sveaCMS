package com.sveacms.services;

import com.sveacms.entities.AdminProfile;
import com.sveacms.entities.User;
import com.sveacms.entities.UserProfile;
import com.sveacms.repositories.AdminProfileRepository;
import com.sveacms.repositories.UserProfileRepository;
import com.sveacms.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    private final AdminProfileRepository adminProfileRepository;

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AdminProfileRepository adminProfileRepository, UserProfileRepository userProfileRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.adminProfileRepository = adminProfileRepository;
        this.userProfileRepository = userProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User addNew(User user) {
        user.setActive(true);
        int userTypeId = user.getUserType().getUserTypeId();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        if (userTypeId == 2) {
            adminProfileRepository.save(new AdminProfile(savedUser));
        } else {
            userProfileRepository.save(new UserProfile(savedUser));
        }
        return savedUser;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
