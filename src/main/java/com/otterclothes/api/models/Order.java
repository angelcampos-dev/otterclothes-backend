package com.otterclothes.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("order_id")
    @Column(name = "order_id")
    private Integer orderId;

    @JsonProperty("total_price_order")
    @Column(name = "total_price_order", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPriceOrder;

    @JsonProperty("date_order")
    @Column(name = "date_order")
    private LocalDate dateOrder;

    @JsonProperty("user")
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonProperty("address")
    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @JsonProperty("order_payment")
    @Column(name = "order_payment", length = 45)
    private String orderPayment;
}
