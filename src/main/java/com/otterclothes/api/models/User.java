package com.otterclothes.api.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("user_id")
    @Column(name = "user_id")
    private Integer userId;

    @JsonProperty("user_full_name")
    @Column(name = "user_full_name", nullable = false, length = 100)
    private String userFullName;

    @JsonProperty("user_email")
    @Column(name = "user_email", nullable = false, unique = true, length = 100)
    private String userEmail;

    @JsonProperty("user_phone")
    @Column(name = "user_phone", nullable = false, length = 13)
    private String userPhone;

    @JsonProperty(value = "user_password", access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "user_password", nullable = false, length = 60)
    private String userPassword;
}
