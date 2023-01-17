package com.challenge.personAPI.controller.Address;

import com.challenge.personAPI.controller.Person.PersonRequest;
import com.challenge.personAPI.controller.Person.PersonResponse;
import com.challenge.personAPI.model.AddressModel;
import com.challenge.personAPI.model.PersonModel;

public class AddressMapper {
    public static AddressModel toEntity(AddressRequest addressRequest) {

        AddressModel addressModel = new AddressModel();
        addressModel.setCep(addressRequest.getCep());
        addressModel.setCity(addressRequest.getCity());
        addressModel.setNumber(addressRequest.getNumber());
        addressModel.setPublicPlace(addressRequest.getPublicPlace());
        return addressModel;
    }

    public static AddressModel toEntity(AddressRequest addressRequest, Integer id) {
        AddressModel addressModel = toEntity(addressRequest);
        addressModel.setId(id);
        return addressModel;
    }

    public static AddressResponse toResponse(AddressModel addressModel) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(addressModel.getId());
        addressResponse.setCep(addressModel.getCep());
        addressResponse.setCity(addressModel.getCity());
        addressResponse.setNumber(addressModel.getNumber());
        addressResponse.setPublicPlace(addressResponse.getPublicPlace());
        return addressResponse;
    }
}
