package com.creditdecisionsupport.demo.service.impl;

import com.creditdecisionsupport.demo.entity.Address;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.creditdecisionsupport.demo.message.SystemMessage;
import com.creditdecisionsupport.demo.repository.AddressRepository;
import com.creditdecisionsupport.demo.repository.CustomerRepository;
import com.creditdecisionsupport.demo.response.DeleteAddressResponse;
import com.creditdecisionsupport.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<Object> createAddress(Address address) {

        Customer customer = customerRepository.findByIdentityNumber(address.getIdentityNumber());

        if(customer == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");

        addressRepository.save(address);

        return ResponseEntity.status(HttpStatus.OK).body(address);

    }

    @Override
    public ResponseEntity<DeleteAddressResponse> deleteAddress(Long id) {

        Optional<Address> address = addressRepository.findById(id);
        DeleteAddressResponse deleteAddressResponse = new DeleteAddressResponse();

        if (!(address.isPresent())) {
            deleteAddressResponse.setMessage(SystemMessage.ADDRESS_DELETE_FAILED);
            deleteAddressResponse.setId(id);
            deleteAddressResponse.setCode(HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(deleteAddressResponse);
        }

        deleteAddressResponse.setMessage(SystemMessage.ADDRESS_DELETE_SUCCESS);
        deleteAddressResponse.setId(id);
        deleteAddressResponse.setCode(HttpStatus.OK.value());

        address.ifPresent(address1 -> addressRepository.delete(address1));
        return ResponseEntity.status(HttpStatus.OK).body(deleteAddressResponse);

    }
}
