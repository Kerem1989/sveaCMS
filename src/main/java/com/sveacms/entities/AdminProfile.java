package com.sveacms.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_profile")
public class AdminProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int adminProfileId;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private User userId;

    private String company;

    @Embedded
    private ContactInfo contactInfo;

    public AdminProfile() {
    }

    public AdminProfile(int adminProfileId, User userId, String company, ContactInfo contactInfo) {
        this.adminProfileId = adminProfileId;
        this.userId = userId;
        this.company = company;
        this.contactInfo = contactInfo;
    }

    public AdminProfile(User user) {
        this.userId = user;
        this.contactInfo = new ContactInfo();
    }

    public int getAdminProfileId() {
        return adminProfileId;
    }

    public void setAdminProfileId(int adminProfileId) {
        this.adminProfileId = adminProfileId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "AdminProfile{" +
                "adminProfileId=" + adminProfileId +
                ", userId=" + userId +
                ", company='" + company + '\'' +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
