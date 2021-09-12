package com.creditdecisionsupport.demo.service;


import com.creditdecisionsupport.demo.entity.Contact;
import org.springframework.http.ResponseEntity;

public interface ContactService {

    public ResponseEntity<Object> delete(Long id);
    public ResponseEntity<Object> create(Contact contact);
}
