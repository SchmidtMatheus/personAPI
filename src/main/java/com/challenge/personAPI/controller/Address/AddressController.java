package com.challenge.personAPI.controller.Address;



import com.challenge.personAPI.model.AddressModel;
import com.challenge.personAPI.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/address")
@Component
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/visualization")
    public List<AddressResponse> list() {
        ArrayList<AddressResponse> addressList = new ArrayList<>();
        addressService.findAll().forEach(addressModel -> {
            addressList.add(AddressMapper.toResponse(addressModel));
        });
        return addressList;
    }

    @GetMapping("/visualization/{id}")
    public AddressResponse findId(@PathVariable("id") Integer id) {
        AddressModel addressModel = addressService.findById(id);
        return AddressMapper.toResponse(addressModel);
    }

    @PostMapping("/create")
    public AddressModel create(@RequestBody AddressRequest adressRequest) {
        AddressModel addressModel = AddressMapper.toEntity(adressRequest);
        return addressService.save(addressModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        addressService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/edit/{id}")
    public AddressModel edit(@PathVariable("id") Integer id, @RequestBody AddressRequest addressRequest) {
        AddressModel addressModel = AddressMapper.toEntity(addressRequest, id);
        return addressService.save(addressModel);
    }
}
