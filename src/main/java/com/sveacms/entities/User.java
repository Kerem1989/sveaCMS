package com.sveacms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="users")
public class User {

    @Id
    private Long UserId;

    @Column(unique=true)
    private String email;

    @NotEmpty
    private String password;

    private boolean IsActive;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date registrationDate;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userTypeId", referencedColumnName ="userTypeId")
    private UserType userTypeId;

    public User() {
    }

    public User(Long userId, String email, String password, boolean isActive, Date registrationDate, UserType userTypeId) {
        UserId = userId;
        this.email = email;
        this.password = password;
        IsActive = isActive;
        this.registrationDate = registrationDate;
        this.userTypeId = userTypeId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public UserType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
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
                "UserId=" + UserId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", IsActive=" + IsActive +
                ", registrationDate=" + registrationDate +
                ", userTypeId=" + userTypeId +
                '}';
    }
}
