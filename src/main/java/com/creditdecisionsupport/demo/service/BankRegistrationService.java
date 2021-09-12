package com.creditdecisionsupport.demo.service;

import com.creditdecisionsupport.demo.bankenums.BankList;
import org.springframework.http.ResponseEntity;

public interface BankRegistrationService {

    public ResponseEntity<Object> register(String identityNumber, BankList bank);

}
