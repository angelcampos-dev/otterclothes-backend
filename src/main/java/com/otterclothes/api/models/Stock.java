package com.otterclothes.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "stock_id")
    private Integer stockId;

    @Column(name = "size", nullable = false, length = 1)
    private String size;

    @Column(name = "color", nullable = false, length = 45)
    private String color;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "model", nullable = false, unique = true, length = 45)
    private String model;

    @Column(name = "quant", nullable = false)
    private Integer quant;

    @Column(name = "style", nullable = false, length = 45)
    private String style;

    // para las relaciones de ordenes
    @Column(name = "order_items_order_items_id", nullable = false)
    private Integer orderItemsId;

    // contrsuctor vasio de prueba
    //public Stock() {}

    // getter y setters
    public Integer getStockId() { return stockId; }
    public void setStockId(Integer stockId) { this.stockId = stockId; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getQuant() { return quant; }
    public void setQuant(Integer quant) { this.quant = quant; }

    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }

    public Integer getOrderItemsId() { return orderItemsId; }
    public void setOrderItemsId(Integer orderItemsId) { this.orderItemsId = orderItemsId; }
}
