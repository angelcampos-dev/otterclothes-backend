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
@Table(name = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("color_id")
    @Column(name = "color_id")
    private Integer colorId;

    @JsonProperty("color_name")
    @Column(name = "color_name", nullable = false, unique = true, length = 45)
    private String colorName;
}