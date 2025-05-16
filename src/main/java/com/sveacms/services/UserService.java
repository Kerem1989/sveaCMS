package com.sveacms.services;

import com.sveacms.entities.AdminProfile;
import com.sveacms.entities.User;
import com.sveacms.entities.UserProfile;
import com.sveacms.entities.UserType;
import com.sveacms.repositories.AdminProfileRepository;
import com.sveacms.repositories.UserProfileRepository;
import com.sveacms.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    private final AdminProfileRepository adminProfileRepository;

    private final UserProfileRepository userProfileRepository;

    public UserService(UserRepository userRepository, AdminProfileRepository adminProfileRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.adminProfileRepository = adminProfileRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public User addNew(User user) {
        user.setActive(true);
        int userTypeId = user.getUserType().getUserTypeId();
        User savedUser = userRepository.save(user);
        System.out.println(savedUser);
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

    public ArrayList<User> findAll() {
        return (ArrayList<User>) userRepository.findAll();
    }
}
