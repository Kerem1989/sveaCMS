package com.sveacms;

import com.sveacms.entities.ContactInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactInfoTest {

    @Test
    void testAllGettersAndSetters() {
        ContactInfo contact = new ContactInfo();

        contact.setFirstName("John");
        contact.setLastName("Doe");
        contact.setCity("Stockholm");
        contact.setState("Stockholms län");
        contact.setCountry("Sweden");
        contact.setPhone("+46700000000");
        contact.setProfilePhoto("profile.jpg");

        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("Stockholm", contact.getCity());
        assertEquals("Stockholms län", contact.getState());
        assertEquals("Sweden", contact.getCountry());
        assertEquals("+46700000000", contact.getPhone());
        assertEquals("profile.jpg", contact.getProfilePhoto());
    }

    @Test
    void testConstructorWithAllFields() {
        ContactInfo contact = new ContactInfo(
                "Jane",
                "avatar.png",
                "+4612345678",
                "Sweden",
                "Skåne",
                "Malmö",
                "Andersson"
        );

        assertEquals("Jane", contact.getFirstName());
        assertEquals("avatar.png", contact.getProfilePhoto());
        assertEquals("+4612345678", contact.getPhone());
        assertEquals("Sweden", contact.getCountry());
        assertEquals("Skåne", contact.getState());
        assertEquals("Malmö", contact.getCity());
        assertEquals("Andersson", contact.getLastName());
    }

    @Test
    void testToString() {
        ContactInfo contact = new ContactInfo();
        contact.setFirstName("Anna");
        assertTrue(contact.toString().contains("firstName='Anna'"));
    }
}
