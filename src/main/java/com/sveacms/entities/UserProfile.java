package com.sveacms.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userProfileId;

    @OneToOne
    @JoinColumn(name = "user_profile_id")
    @MapsId
    private User userId;

    @Embedded
    private ContactInfo contactInfo;

    public UserProfile(int userProfileId, User userId, ContactInfo contactInfo) {
        this.userProfileId = userProfileId;
        this.userId = userId;
        this.contactInfo = contactInfo;
    }

    public UserProfile() {
    }

    public UserProfile(User user) {
        this.userId = user;
    }

    public int getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(int userProfileId) {
        this.userProfileId = userProfileId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userProfileId=" + userProfileId +
                ", userId=" + userId +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
