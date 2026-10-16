package com.otterclothes.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("address_id")
    @Column(name = "address_id")
    private Integer addressId;

    @JsonProperty("user")
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonProperty("address_alias")
    @Column(name = "address_alias", length = 45)
    private String addressAlias;

    @JsonProperty("state")
    @Column(name = "state", nullable = false, length = 45)
    private String state;

    @JsonProperty("city")
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @JsonProperty("neighborhood")
    @Column(name = "neighborhood", nullable = false, length = 45)
    private String neighborhood;

    @JsonProperty("street")
    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @JsonProperty("house_number")
    @Column(name = "house_number", nullable = false, length = 20)
    private String houseNumber;

    @JsonProperty("postal_code")
    @Column(name = "postal_code", nullable = false, length = 10)
    private String postalCode;

    @JsonProperty("is_default")
    @Column(name = "is_default", nullable = false, columnDefinition = "TINYINT")
    private Boolean defaultAddress;
}