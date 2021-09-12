package com.creditdecisionsupport.demo.service.impl;

import com.creditdecisionsupport.demo.bankenums.BankList;
import com.creditdecisionsupport.demo.domain.BankRepositoryDomain;
import com.creditdecisionsupport.demo.entity.BankRegistration;
import com.creditdecisionsupport.demo.entity.bank.Bank;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.creditdecisionsupport.demo.repository.BankRegistrationRepository;
import com.creditdecisionsupport.demo.repository.CustomerRepository;
import com.creditdecisionsupport.demo.repository.bank.BankRepository;
import com.creditdecisionsupport.demo.service.BankRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BankRegistrationServiceImpl implements BankRegistrationService {


    private final BankRegistrationRepository bankRegistrationRepository;
    private final CustomerRepository customerRepository;
    private final BankRepository bankRepository;
    private final BankRepositoryDomain bankRepositoryDomain;

    @Autowired
    public BankRegistrationServiceImpl(BankRegistrationRepository bankRegistrationRepository,
                                       CustomerRepository customerRepository, BankRepository bankRepository,
                                       BankRepositoryDomain bankRepositoryDomain) {
        this.bankRegistrationRepository = bankRegistrationRepository;
        this.customerRepository = customerRepository;
        this.bankRepository = bankRepository;
        this.bankRepositoryDomain = bankRepositoryDomain;
    }




    @Override
    public ResponseEntity<Object> register(String identityNumber, BankList bank) {

        Customer customer = customerRepository.findByIdentityNumber(identityNumber);

        String bankName = bank.toString();

        Bank selectedBank = bankRepository.findByName(bankName);
        BankRepository bankRepository = bankRepositoryDomain.bankRepository(bankName);

        BankRegistration registration = new BankRegistration();


        registration.setBank(selectedBank);
        registration.setCustomer(customer);
        registration.setNameOfBank(bankName);

        bankRegistrationRepository.save(registration);

        customer.getRegistrationList().add(registration);
        selectedBank.getRegistrationList().add(registration);

        customerRepository.save(customer);
        bankRepository.save(selectedBank);

        return ResponseEntity.status(200).body("Registered!");

    }
}
