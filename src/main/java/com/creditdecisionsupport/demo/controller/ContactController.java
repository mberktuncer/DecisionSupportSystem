package com.creditdecisionsupport.demo.controller;

import com.creditdecisionsupport.demo.entity.Contact;
import com.creditdecisionsupport.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contact")
public class ContactController implements ContactService {
    @Autowired
    private ContactService contactService;

    @PostMapping("/create")
    @Override
    public ResponseEntity<Object> create(Contact contact) {
        return contactService.create(contact);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@Valid @PathVariable Long id) {
        return contactService.delete(id);
    }
}