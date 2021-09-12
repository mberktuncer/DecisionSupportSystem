package com.creditdecisionsupport.demo.controller;

import com.creditdecisionsupport.demo.bankenums.BankList;
import com.creditdecisionsupport.demo.service.BankRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/bank/")
public class BankRegistrationController {

    @Autowired
    private BankRegistrationService bankRegistrationService;

    @PostMapping("/register/{identityNumber}/{bankList}")
    public ResponseEntity<Object> register(@PathVariable String identityNumber,@PathVariable BankList bankList){

        return bankRegistrationService.register(identityNumber,bankList);
    }

}
