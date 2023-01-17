package com.challenge.personAPI.controller.Person;

import com.challenge.personAPI.model.AddressModel;
import com.challenge.personAPI.model.PersonModel;

public class PersonMapper {
    public static PersonModel toEntity(PersonRequest personRequest) {
        AddressModel addressModel = new AddressModel();

        PersonModel personModel = new PersonModel();
        personModel.setName(personRequest.getName());
        personModel.setBirthdate(personRequest.getBirthdate());

        addressModel.setId(personRequest.getMainAddressId());
        personModel.setMainAdress(addressModel);
        return personModel;
    }

    public static PersonModel toEntity(PersonRequest personRequest, Integer id) {
        PersonModel personModel = toEntity(personRequest);
        personModel.setId(id);
        return personModel;
    }

    public static PersonResponse toResponse(PersonModel personModel) {
        PersonResponse personResponse = new PersonResponse();

        personResponse.setId(personModel.getId());
        personResponse.setName(personModel.getName());
        personResponse.setBirthdate(personModel.getBirthdate());
        personResponse.setMainAddressId(personModel.getMainAdress().getId());
        return personResponse;
    }
}
