package com.creditdecisionsupport.demo.service;

import com.creditdecisionsupport.demo.entity.Address;
import com.creditdecisionsupport.demo.response.DeleteAddressResponse;
import org.springframework.http.ResponseEntity;

public interface AddressService {

    public ResponseEntity<Object> createAddress(Address address);
    public ResponseEntity<DeleteAddressResponse> deleteAddress(Long id);

}
