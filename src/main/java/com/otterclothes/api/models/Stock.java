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
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("stock_id")
    @Column(name = "stock_id")
    private Integer stockId;

    @JsonProperty("quant")
    @Column(name = "quant", nullable = false)
    private Integer quant;

    @JsonProperty("product")
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @JsonProperty("size")
    @ManyToOne(optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @JsonProperty("color")
    @ManyToOne(optional = false)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;
}
