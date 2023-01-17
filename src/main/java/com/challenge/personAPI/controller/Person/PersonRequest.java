package com.challenge.personAPI.controller.Person;

import lombok.Data;

import java.util.Date;


@Data
public class PersonRequest {

    private String name;
    private Date birthdate;
    private Integer mainAddressId;
}
