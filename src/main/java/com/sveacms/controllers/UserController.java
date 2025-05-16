package com.sveacms.controllers;

import com.sveacms.entities.User;
import com.sveacms.entities.UserType;
import com.sveacms.repositories.UserTypeRepository;
import com.sveacms.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final UserTypeRepository userTypeRepository;
    private final UserService userService;

    public UserController(UserTypeRepository userTypeRepository, UserService userService) {
        this.userTypeRepository = userTypeRepository;
        this.userService = userService;
    }


    @GetMapping("/register")
    public String register(Model model) {
        List<UserType> userTypes = userTypeRepository.findAll();
        model.addAttribute("getAllTypes", userTypes);
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid User user, Model model) {
        Optional<User> optionalUsers = userService.getUserByEmail(user.getEmail());
        if (optionalUsers.isPresent()) {
            model.addAttribute("error", "This email already exists, try another one");
            List<UserType> userTypes = userTypeRepository.findAll();
            model.addAttribute("getAllTypes", userTypes);
            model.addAttribute("user", new User());
            return "register";
        }
        userService.addNew(user);
        return "dashboard";
    }


}
