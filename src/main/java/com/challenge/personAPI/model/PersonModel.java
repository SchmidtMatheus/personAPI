package com.challenge.personAPI.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data

@Table(name = "person")
public class PersonModel {


    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthdate", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;

    @OneToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name = "mainAdressId",nullable=false)
    private AddressModel mainAdress;

}
