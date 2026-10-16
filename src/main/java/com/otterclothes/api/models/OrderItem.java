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
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("order_items_id")
    @Column(name = "order_items_id")
    private Integer orderItemsId;

    @JsonProperty("order")
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @JsonProperty("stock")
    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_stock_id", nullable = false)
    private Stock stock;

    @JsonProperty("quant_item")
    @Column(name = "quant_item", nullable = false)
    private Integer quantItem;
}
