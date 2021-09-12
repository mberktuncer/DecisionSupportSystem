package com.creditdecisionsupport.demo.controller;

import com.creditdecisionsupport.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController{

    @Autowired
    private BankService bankService;

    @PostMapping("/save/all")
    public ResponseEntity<Object> saveAllBank(){
        return bankService.create();
    }

}
