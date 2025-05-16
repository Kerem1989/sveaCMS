package com.sveacms.controllers;

import com.sveacms.entities.User;
import com.sveacms.entities.UserType;
import com.sveacms.services.UserService;
import com.sveacms.repositories.UserTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserTypeRepository userTypeRepository;

    @Test
    void testRegisterPageLoads() throws Exception {
        List<UserType> types = List.of(new UserType());
        when(userTypeRepository.findAll()).thenReturn(types);

        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("getAllTypes"))
                .andExpect(model().attributeExists("user"));
    }

    @Test
    void testUserRegistration_EmailExists() throws Exception {
        User user = new User();
        user.setEmail("existing@example.com");

        when(userService.getUserByEmail("existing@example.com")).thenReturn(Optional.of(user));
        when(userTypeRepository.findAll()).thenReturn(List.of(new UserType()));

        mockMvc.perform(post("/register/new")
                        .param("email", "existing@example.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("error"))
                .andExpect(model().attributeExists("getAllTypes"))
                .andExpect(model().attributeExists("user"));
    }

    @Test
    void testUserRegistration_NewEmail() throws Exception {
        when(userService.getUserByEmail("new@example.com")).thenReturn(Optional.empty());

        mockMvc.perform(post("/register/new")
                        .param("email", "new@example.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard"));

        verify(userService).addNew(any(User.class));
    }
}
