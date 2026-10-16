package com.otterclothes.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "favs")
public class Fav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("favs_id")
    @Column(name = "favs_id")
    private Integer favsId;

    @JsonProperty("user")
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonProperty("favs_date")
    @Column(name = "favs_date", nullable = false)
    private LocalDate favsDate;

    @JsonProperty("stock")
    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;
}