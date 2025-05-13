package com.sveacms;

import com.sveacms.entities.User;
import com.sveacms.entities.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTypeTest {

    private UserType userType;

    @BeforeEach
    void setUp() {
        userType = new UserType();
    }

    @Test
    void testUserTypeId() {
        userType.setUserTypeId(1);
        assertEquals(1, userType.getUserTypeId());
    }

    @Test
    void testUserTypeName() {
        userType.setUserTypeName("ADMIN");
        assertEquals("ADMIN", userType.getUserTypeName());
    }

    @Test
    void testUsersList() {
        User user1 = new User();
        user1.setUserId(1);
        user1.setEmail("user1@example.com");

        User user2 = new User();
        user2.setUserId(2);
        user2.setEmail("user2@example.com");

        List<User> users = Arrays.asList(user1, user2);
        userType.setUsers(users);

        assertEquals(2, userType.getUsers().size());
        assertEquals("user1@example.com", userType.getUsers().get(0).getEmail());
    }

    @Test
    void testToStringNotNull() {
        userType.setUserTypeId(1);
        userType.setUserTypeName("EDITOR");

        String str = userType.toString();
        assertNotNull(str);
        assertTrue(str.contains("userTypeId=1"));
        assertTrue(str.contains("userTypeName='EDITOR"));
    }
}
