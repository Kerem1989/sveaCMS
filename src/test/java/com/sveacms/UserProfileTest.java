package com.sveacms;

import com.sveacms.entities.ContactInfo;
import com.sveacms.entities.User;
import com.sveacms.entities.UserProfile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserProfileTest {

    @Test
    void testGettersAndSetters() {
        UserProfile profile = new UserProfile();
        User user = new User();
        ContactInfo contact = new ContactInfo();

        profile.setUserProfileId(5);
        profile.setUserId(user);
        profile.setContactInfo(contact);

        assertEquals(5, profile.getUserProfileId());
        assertEquals(user, profile.getUserId());
        assertEquals(contact, profile.getContactInfo());
    }

    @Test
    void testConstructorWithAllFields() {
        User user = new User();
        ContactInfo contact = new ContactInfo();
        UserProfile profile = new UserProfile(99, user, contact);

        assertEquals(99, profile.getUserProfileId());
        assertEquals(user, profile.getUserId());
        assertEquals(contact, profile.getContactInfo());
    }

    @Test
    void testConstructorWithUserOnly() {
        User user = new User();
        UserProfile profile = new UserProfile(user);

        assertEquals(user, profile.getUserId());
        assertNull(profile.getContactInfo()); // eftersom contactInfo inte sätts i denna konstruktor
    }

    @Test
    void testToStringContainsUserProfileId() {
        UserProfile profile = new UserProfile();
        profile.setUserProfileId(1);

        String result = profile.toString();
        assertTrue(result.contains("userProfileId=1"));
    }
}
