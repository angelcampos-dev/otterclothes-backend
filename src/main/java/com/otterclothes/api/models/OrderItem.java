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
@Table(name = "order_items")
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_items_id")
    private Integer orderItemsId;

    // esto esta unido a la columna order_id de la tabla
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "order_payment", nullable = false, length = 45)
    private String orderPayment;

    // constructor vacio de prueva
    //public OrderItem() {}

    // getter y setter
    public Integer getOrderItemsId() { return orderItemsId; }
    public void setOrderItemsId(Integer orderItemsId) { this.orderItemsId = orderItemsId; }

    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public String getOrderPayment() { return orderPayment; }
    public void setOrderPayment(String orderPayment) { this.orderPayment = orderPayment; }
}
