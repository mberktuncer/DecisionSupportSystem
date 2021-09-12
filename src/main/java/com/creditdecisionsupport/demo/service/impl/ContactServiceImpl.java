package com.creditdecisionsupport.demo.service.impl;

import com.creditdecisionsupport.demo.entity.Contact;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.creditdecisionsupport.demo.repository.ContactRepository;
import com.creditdecisionsupport.demo.repository.CustomerRepository;
import com.creditdecisionsupport.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<Object> create(Contact contact) {

        Customer customer = customerRepository.findByIdentityNumber(contact.getIdentityNumber());

        if(customer == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");

        contactRepository.save(contact);
        return ResponseEntity.status(HttpStatus.OK).body(contact);
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {

        Optional<Contact> contact = contactRepository.findById(id);

        if(!contact.isPresent()){

            return ResponseEntity.status(404).body("Contact not found");

        }
        contact.ifPresent(a->contactRepository.delete(a));

        return ResponseEntity.status(200).body("Contact deleted");
    }
}
