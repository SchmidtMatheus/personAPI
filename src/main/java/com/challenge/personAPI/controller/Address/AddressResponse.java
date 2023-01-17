package com.challenge.personAPI.controller.Address;

import lombok.Data;

import java.util.Date;

@Data
public class AddressResponse {

    private int id;
    private String publicPlace;
    private String cep;
    private Integer number;
    private String city;
}
