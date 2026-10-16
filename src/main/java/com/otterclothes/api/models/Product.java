package com.otterclothes.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("product_id")
    @Column(name = "product_id")
    private Integer productId;

    @JsonProperty("product_name")
    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @JsonProperty("description")
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @JsonProperty("price")
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @JsonProperty("model")
    @Column(name = "model", length = 45)
    private String model;

    @JsonProperty("style")
    @Column(name = "style", length = 45)
    private String style;
}