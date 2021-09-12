package com.creditdecisionsupport.demo.controller;

import com.creditdecisionsupport.demo.params.TakeCreditParams;
import com.creditdecisionsupport.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditController implements CreditService {

    @Autowired
    private CreditService creditService;

    @PostMapping("/take")
    @Override
    public ResponseEntity<Object> takeCredit(@RequestBody TakeCreditParams params) {
        return creditService.takeCredit(params);
    }

}
