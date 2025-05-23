package com.sveacms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(unique=true)
    private String email;

    @NotEmpty
    private String password;

    private boolean IsActive;

    private LocalDate registrationDate;

    @PrePersist
    public void onCreate() {
        if (registrationDate == null) {
            registrationDate = LocalDate.now();
        }
    }


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userTypeId", referencedColumnName ="userTypeId")
    private UserType userType;

    public User() {
    }

    public User(int userId, String email, String password, boolean isActive, LocalDate registrationDate, UserType userType) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        IsActive = isActive;
        this.registrationDate = registrationDate;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", IsActive=" + IsActive +
                ", registrationDate=" + registrationDate +
                ", userTypeId=" + userType +
                '}';
    }
}
