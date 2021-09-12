package com.creditdecisionsupport.demo.controller;

import com.creditdecisionsupport.demo.entity.Address;
import com.creditdecisionsupport.demo.response.DeleteAddressResponse;
import com.creditdecisionsupport.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController implements AddressService {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    @Override
    public ResponseEntity<Object> createAddress(Address address) {
        return addressService.createAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<DeleteAddressResponse> deleteAddress(@Valid @PathVariable Long id) {
        return addressService.deleteAddress(id);
    }

}
