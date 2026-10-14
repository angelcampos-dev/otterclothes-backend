package com.otterclothes.api.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_full_name", nullable = false, length = 100)
    private String userFullName;

    @Column(name = "user_email", nullable = false, unique = true, length = 100)
    private String userEmail;

    @Column(name = "user_phone", nullable = false, length = 13)
    private String userPhone;

    @Column(name = "user_pc", nullable = false, length = 45)
    private String userPc;

    @Column(name = "user_state", nullable = false, length = 45)
    private String userState;

    @Column(name = "user_city", nullable = false, length = 45)
    private String userCity;

    @Column(name = "user_nb", nullable = false, length = 45)
    private String userNb;

    @Column(name = "user_street", nullable = false, length = 45)
    private String userStreet;

    @Column(name = "user_house_number", nullable = false, length = 45)
    private String userHouseNumber;

    @Column(name = "user_password", nullable = false, length = 45)
    private String userPassword;

    //public User() {}

    // getters y setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUserFullName() { return userFullName; }
    public void setUserFullName(String userFullName) { this.userFullName = userFullName; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserPhone() { return userPhone; }
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }

    public String getUserPc() { return userPc; }
    public void setUserPc(String userPc) { this.userPc = userPc; }

    public String getUserState() { return userState; }
    public void setUserState(String userState) { this.userState = userState; }

    public String getUserCity() { return userCity; }
    public void setUserCity(String userCity) { this.userCity = userCity; }

    public String getUserNb() { return userNb; }
    public void setUserNb(String userNb) { this.userNb = userNb; }

    public String getUserStreet() { return userStreet; }
    public void setUserStreet(String userStreet) { this.userStreet = userStreet; }

    public String getUserHouseNumber() { return userHouseNumber; }
    public void setUserHouseNumber(String userHouseNumber) { this.userHouseNumber = userHouseNumber; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

}
