package com.sveacms;

import com.sveacms.entities.*;
import com.sveacms.repositories.AdminProfileRepository;
import com.sveacms.repositories.UserProfileRepository;
import com.sveacms.repositories.UserRepository;
import com.sveacms.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AdminProfileRepository adminProfileRepository;

    @Mock
    private UserProfileRepository userProfileRepository;

    private User adminUser;
    private User regularUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        adminUser = new User();
        adminUser.setUserId(1);
        adminUser.setEmail("admin@example.com");
        UserType adminType = new UserType();
        adminType.setUserTypeId(2); // Admin
        adminUser.setUserType(adminType);

        regularUser = new User();
        regularUser.setUserId(2);
        regularUser.setEmail("user@example.com");
        UserType regularType = new UserType();
        regularType.setUserTypeId(1); // Regular
        regularUser.setUserType(regularType);
    }

    @Test
    void testAddNew_AdminUser_SavesAdminProfile() {
        when(userRepository.save(adminUser)).thenReturn(adminUser);

        User saved = userService.addNew(adminUser);

        assertTrue(saved.isActive());
        verify(userRepository).save(adminUser);
        verify(adminProfileRepository).save(any(AdminProfile.class));
        verify(userProfileRepository, never()).save(any(UserProfile.class));
    }

    @Test
    void testAddNew_RegularUser_SavesUserProfile() {
        when(userRepository.save(regularUser)).thenReturn(regularUser);

        User saved = userService.addNew(regularUser);

        assertTrue(saved.isActive());
        verify(userRepository).save(regularUser);
        verify(userProfileRepository).save(any(UserProfile.class));
        verify(adminProfileRepository, never()).save(any(AdminProfile.class));
    }

    @Test
    void testGetUserByEmail_Found() {
        when(userRepository.findByEmail("admin@example.com")).thenReturn(Optional.of(adminUser));

        Optional<User> result = userService.getUserByEmail("admin@example.com");

        assertTrue(result.isPresent());
        assertEquals("admin@example.com", result.get().getEmail());
        verify(userRepository).findByEmail("admin@example.com");
    }

    @Test
    void testGetUserByEmail_NotFound() {
        when(userRepository.findByEmail("nope@example.com")).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserByEmail("nope@example.com");

        assertFalse(result.isPresent());
        verify(userRepository).findByEmail("nope@example.com");
    }

    @Test
    void testFindAll_ReturnsList() {
        List<User> mockList = Arrays.asList(adminUser, regularUser);
        when(userRepository.findAll()).thenReturn(mockList);

        List<User> result = userService.findAll();

        assertEquals(2, result.size());
        verify(userRepository).findAll();
    }
}
