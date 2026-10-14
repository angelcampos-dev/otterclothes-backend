package com.otterclothes.api.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "quant_order", nullable = false)
    private Integer quantOrder;

    @Column(name = "total_price_order", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPriceOrder;

    @Column(name = "date_order", nullable = false)
    private LocalDate dateOrder;

    @Column(name = "total_quant_order", nullable = false)
    private Integer totalQuantOrder;

    // aqui se conecta con el usuario
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    //public Order() {} era un contrusctor de prueba

    // getters y setters
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public Integer getQuantOrder() { return quantOrder; }
    public void setQuantOrder(Integer quantOrder) { this.quantOrder = quantOrder; }

    public BigDecimal getTotalPriceOrder() { return totalPriceOrder; }
    public void setTotalPriceOrder(BigDecimal totalPriceOrder) { this.totalPriceOrder = totalPriceOrder; }

    public LocalDate getDateOrder() { return dateOrder; }
    public void setDateOrder(LocalDate dateOrder) { this.dateOrder = dateOrder; }

    public Integer getTotalQuantOrder() { return totalQuantOrder; }
    public void setTotalQuantOrder(Integer totalQuantOrder) { this.totalQuantOrder = totalQuantOrder; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
}
