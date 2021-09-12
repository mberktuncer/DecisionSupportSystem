package com.creditdecisionsupport.demo.service;

import com.creditdecisionsupport.demo.params.TakeCreditParams;
import org.springframework.http.ResponseEntity;

public interface CreditService {

    public ResponseEntity<Object> takeCredit(TakeCreditParams params);

}
