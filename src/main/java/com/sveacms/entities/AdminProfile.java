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

    private String firstName;

    private String lastName;

    private String city;

    private String state;

    private String country;

    private String company;

    private String phone;

    @Column(nullable=true, length=64)
    private String profilePhoto;

    public AdminProfile(int adminProfileId, User userId, String firstName, String lastName, String state, String city, String country, String company, String phone, String profilePhoto) {
        this.adminProfileId = adminProfileId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.country = country;
        this.company = company;
        this.phone = phone;
        this.profilePhoto = profilePhoto;
    }

    public AdminProfile() {
    }

    public AdminProfile(User user) {
        this.userId = user;
    }

    public int getAdminProfileId() {
        return adminProfileId;
    }

    public void setAdminProfileId(int adminProfileId) {
        this.adminProfileId = adminProfileId;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AdminProfile{" +
                "adminProfileId=" + adminProfileId +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                '}';
    }
}
