package com.sveacms;

import com.sveacms.entities.User;
import com.sveacms.entities.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

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
    void testIsActive() {
        user.setActive(true);
        assertTrue(user.isActive());
    }

    @Test
    void testRegistrationDateSetter() {
        LocalDate registrationDate = LocalDate.of(2024, 1, 1);
        user.setRegistrationDate(registrationDate);
        assertEquals(registrationDate, user.getRegistrationDate());
    }

    @Test
    void testUserType() {
        UserType type = new UserType();
        type.setUserTypeId(1);
        user.setUserType(type);
        assertEquals(type, user.getUserType());
    }

    @Test
    void testToStringContainsEmail() {
        user.setEmail("visible@test.com");
        assertTrue(user.toString().contains("visible@test.com"));
    }

    @Test
    void testPrePersistSetsDateIfNull() {
        assertNull(user.getRegistrationDate());
        user.onCreate();
        assertNotNull(user.getRegistrationDate());
    }

    @Test
    void testFullConstructor() {
        UserType type = new UserType();
        LocalDate date = LocalDate.of(2025, 1, 1);
        User fullUser = new User(5, "full@example.com", "pass", true, date, type);

        assertEquals(5, fullUser.getUserId());
        assertEquals("full@example.com", fullUser.getEmail());
        assertEquals("pass", fullUser.getPassword());
        assertTrue(fullUser.isActive());
        assertEquals(date, fullUser.getRegistrationDate());
        assertEquals(type, fullUser.getUserType());
    }
}
