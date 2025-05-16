package com.sveacms;

import com.sveacms.entities.AdminProfile;
import com.sveacms.entities.ContactInfo;
import com.sveacms.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminProfileTest {

    @Test
    void testGettersAndSetters() {
        AdminProfile profile = new AdminProfile();
        User user = new User();
        ContactInfo info = new ContactInfo();

        profile.setAdminProfileId(10);
        profile.setUserId(user);
        profile.setCompany("TestCompany");
        profile.setContactInfo(info);

        assertEquals(10, profile.getAdminProfileId());
        assertEquals(user, profile.getUserId());
        assertEquals("TestCompany", profile.getCompany());
        assertEquals(info, profile.getContactInfo());
    }

    @Test
    void testFullConstructor() {
        User user = new User();
        ContactInfo contactInfo = new ContactInfo();

        AdminProfile profile = new AdminProfile(42, user, "ExampleCorp", contactInfo);

        assertEquals(42, profile.getAdminProfileId());
        assertEquals(user, profile.getUserId());
        assertEquals("ExampleCorp", profile.getCompany());
        assertEquals(contactInfo, profile.getContactInfo());
    }

    @Test
    void testConstructorWithUserOnly() {
        User user = new User();
        AdminProfile profile = new AdminProfile(user);

        assertEquals(user, profile.getUserId());
        assertNotNull(profile.getContactInfo()); // eftersom den skapas i konstruktorn
    }

    @Test
    void testToStringDoesNotCrash() {
        AdminProfile profile = new AdminProfile();
        profile.setCompany("StringCheck");
        assertTrue(profile.toString().contains("StringCheck"));
    }
}