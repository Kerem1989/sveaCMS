package com.sveacms;

import com.sveacms.entities.UserType;
import com.sveacms.repositories.UserTypeRepository;
import com.sveacms.services.UserTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTypeServiceTest {

    @Mock
    private UserTypeRepository userTypeRepository;

    @InjectMocks
    private UserTypeService userTypeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll_ReturnsUserTypes() {
        UserType admin = new UserType();
        admin.setUserTypeId(1);
        admin.setUserTypeName("ADMIN");

        UserType regular = new UserType();
        regular.setUserTypeId(2);
        regular.setUserTypeName("USER");

        List<UserType> mockList = Arrays.asList(admin, regular);

        when(userTypeRepository.findAll()).thenReturn(mockList);

        List<UserType> result = userTypeService.getAll();

        assertEquals(2, result.size());
        assertEquals("ADMIN", result.get(0).getUserTypeName());
        assertEquals("USER", result.get(1).getUserTypeName());
        verify(userTypeRepository).findAll();
    }
}
