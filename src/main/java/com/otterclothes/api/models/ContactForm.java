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
@Table(name = "contact_form")
public class ContactForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("contact_form_id")
    @Column(name = "contact_form_id")
    private Integer contactFormId;

    @JsonProperty("user")
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonProperty("message")
    @Column(name = "message", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String message;

    @JsonProperty("contact_reason")
    @Column(name = "contact_reason", nullable = false, length = 200)
    private String contactReason;
}