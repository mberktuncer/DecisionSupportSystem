package com.creditdecisionsupport.demo.service.impl;

import com.creditdecisionsupport.demo.builder.CreditNotValidResponseBuilder;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.creditdecisionsupport.demo.mapper.CreditValidityMapper;
import com.creditdecisionsupport.demo.params.TakeCreditParams;
import com.creditdecisionsupport.demo.repository.BankRegistrationRepository;
import com.creditdecisionsupport.demo.repository.CreditRepository;
import com.creditdecisionsupport.demo.repository.CustomerRepository;
import com.creditdecisionsupport.demo.repository.bank.BankRepository;
import com.creditdecisionsupport.demo.response.CreditNotValidResponse;
import com.creditdecisionsupport.demo.service.CreditService;
import com.creditdecisionsupport.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CreditServiceImpl implements CreditService {

    private final CustomerRepository customerRepository;
    private final BankRegistrationRepository bankRegistrationRepository;
    private final BankRepository bankRepository;
    private final CreditRepository creditRepository;

    @Qualifier("customerServiceImpl")
    @Autowired
    private CustomerService customerService;

    @Autowired
    public CreditServiceImpl(CustomerRepository customerRepository, BankRegistrationRepository bankRegistrationRepository, BankRepository bankRepository, CreditRepository creditRepository) {
        this.customerRepository = customerRepository;
        this.bankRegistrationRepository = bankRegistrationRepository;
        this.bankRepository = bankRepository;
        this.creditRepository = creditRepository;
    }


    @Override
    public ResponseEntity<Object> takeCredit(TakeCreditParams params) {

        ResponseEntity<Object> validation = this.checkValidation(params, customerRepository.findByIdentityNumber(params.getIdentityNumber()));

        if(validation.getStatusCode().value() != 200){
            return validation;
        }

        return ResponseEntity.status(404).body("Customer can take credit");

    }

    public static ResponseEntity<Object> giveOffer(TakeCreditParams params){

        double creditAmount = params.getCreditAmount();
        double interestDate = params.getInterestRate();
        long expiryDate = params.getCreditExpiry();
        String creditType = params.getCreditType().toString();
        String identityNumber = params.getIdentityNumber();
        String nameOfBank = params.getNameOfBank();

        return ResponseEntity.status(200).body("");

    }

    public ResponseEntity<Object> checkValidation(TakeCreditParams params, Customer customer){

        if(!customerService.isCustomerExist(params.getIdentityNumber())){

            CreditNotValidResponse response = CreditNotValidResponseBuilder.generateNotValidResponse(params,"CUSTOMER_NOT_FOUND",customer,0);
            return ResponseEntity.status(404).body(response);

        }

        if(!customerService.isCustomerHaveParamBank(params.getIdentityNumber(),params.getNameOfBank())){

            CreditNotValidResponse response = CreditNotValidResponseBuilder.generateNotValidResponse(params,"BANK_NOT_HAVE_CUSTOMER",customer,0);
            return ResponseEntity.status(404).body(response);
        }

        if(!CreditValidityMapper.checkCreditValidity(params.getCreditType().toString(),params.getCreditAmount())){


            CreditNotValidResponse response = CreditNotValidResponseBuilder.generateNotValidResponse(params,"AMOUNT_ERROR",customer,0);
            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body("");

    }
}
