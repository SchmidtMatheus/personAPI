package com.challenge.personAPI.controller.Address;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;


@Data
public class AddressRequest {

    private String publicPlace;
    private String cep;
    private Integer number;
    private String city;
}
