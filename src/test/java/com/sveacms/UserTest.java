package com.sveacms;

import com.sveacms.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testUserId() {
        user.setUserId(1);
        assertEquals(1, user.getUserId());
    }

    @Test
    void testEmail() {
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    void testPassword() {
        user.setPassword("securePass123");
        assertEquals("securePass123", user.getPassword());
    }


    @Test
    void testToStringNotNull() {
        user.setEmail("example@test.com");
        assertNotNull(user.toString());
    }

    @Test
    void testIsActive() {
        user.setActive(true);
        assertTrue(user.isActive());
    }

    @Test
    void testRegistrationDate() {
        LocalDateTime registrationDate = LocalDateTime.now();
        user.setRegistrationDate(registrationDate);
        assertEquals(LocalDateTime.now(), user.getRegistrationDate());
    }
}
