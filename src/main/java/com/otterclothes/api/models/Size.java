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
@Table(name = "sizes")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("size_id")
    @Column(name = "size_id")
    private Integer sizeId;

    @JsonProperty("size_name")
    @Column(name = "size_name", nullable = false, unique = true, length = 10)
    private String sizeName;
}