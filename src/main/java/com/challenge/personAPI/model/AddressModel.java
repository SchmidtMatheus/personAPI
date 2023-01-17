package com.challenge.personAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name = "address")
public class AddressModel {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "publicPlace", nullable = false)
    private String publicPlace;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "Number")
    private Integer number;

    @Column(name = "City", nullable = false)
    private String city;
}
