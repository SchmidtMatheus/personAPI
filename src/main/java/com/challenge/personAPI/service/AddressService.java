package com.challenge.personAPI.service;


import com.challenge.personAPI.model.AddressModel;
import com.challenge.personAPI.repository.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressModel> findAll() {

        return addressRepository.findAll();
    }

    public AddressModel findById(@PathVariable("id") Integer id) {
        return addressRepository.findById(id).get();
    }

    @Transactional
    public AddressModel save(AddressModel addressModel) {
        return addressRepository.save(addressModel);
    }

    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        addressRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
