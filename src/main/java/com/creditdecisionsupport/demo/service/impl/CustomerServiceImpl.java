package com.creditdecisionsupport.demo.service.impl;

import com.creditdecisionsupport.demo.builder.CustomerBuilder;
import com.creditdecisionsupport.demo.domain.CustomerDomain;
import com.creditdecisionsupport.demo.entity.BankRegistration;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.creditdecisionsupport.demo.message.SystemMessage;
import com.creditdecisionsupport.demo.repository.BankRegistrationRepository;
import com.creditdecisionsupport.demo.repository.CustomerRepository;
import com.creditdecisionsupport.demo.response.DeleteCustomerResponse;
import com.creditdecisionsupport.demo.response.RegisteredBankInfo;
import com.creditdecisionsupport.demo.response.RegisteredBankResponse;
import com.creditdecisionsupport.demo.service.CustomerService;
import com.creditdecisionsupport.demo.utility.CommonUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BankRegistrationRepository bankRegistrationRepository;

    @Override
    public ResponseEntity<Object> createCustomer(CustomerDomain customerDomain) {

        CommonUtilities commonUtilities = new CommonUtilities();

        Customer customer = CustomerBuilder.buildCustomer(customerDomain);
        customer.setCustomerNumber(commonUtilities.generateCustomerNumber());

        customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.OK).body(customer);

    }

    @Override
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    @Override
    public ResponseEntity<DeleteCustomerResponse> deleteCustomer(String identityNumber) {

        Customer customer = customerRepository.findByIdentityNumber(identityNumber);
        DeleteCustomerResponse deleteCustomerResponse = new DeleteCustomerResponse();

        if (customer == null){
            deleteCustomerResponse.setMessage(SystemMessage.CUSTOMER_DELETE_FAILED);
            deleteCustomerResponse.setIdentityNumber(identityNumber);
            deleteCustomerResponse.setCode(HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(deleteCustomerResponse);
        }

        deleteCustomerResponse.setMessage(SystemMessage.CUSTOMER_DELETE_SUCCESS);
        deleteCustomerResponse.setIdentityNumber(identityNumber);
        deleteCustomerResponse.setCode(HttpStatus.OK.value());
        customerRepository.delete(customer);
        return ResponseEntity.status(HttpStatus.OK).body(deleteCustomerResponse);
    }

    @Override
    public RegisteredBankResponse getRegisteredBank(String identityNo) {

        Customer customer = customerRepository.findByIdentityNumber(identityNo);

        RegisteredBankResponse response = new RegisteredBankResponse();

        response.setCustomerName(customer.getName());
        response.setCustomerLastname(customer.getLastName());

        List<BankRegistration> bankRegistrations = customer.getRegistrationList();

        //response sınıfında var olan listenin değişken olarak aynısı
        List<RegisteredBankInfo> infos = new ArrayList<>();

        for (BankRegistration bankRegistration : bankRegistrations){

            RegisteredBankInfo info = new RegisteredBankInfo();

            info.setBank(bankRegistration.getBank().getName());
            info.setRegisteredDate(bankRegistration.getRegisteredDate());

            infos.add(info);
        }

        response.setRegisteredBankInfoList(infos);

        return response;
    }

    public Customer getCustomer(String identityNumber){

        return customerRepository.findByIdentityNumber(identityNumber);

    }

    public boolean isCustomerExist(String identityNumber){

        return getCustomer(identityNumber) != null;

    }

    public boolean isCustomerHaveParamBank(String identityNumber,String bankName){

        return bankRegistrationRepository.findByCustomerAndNameOfBank(getCustomer(identityNumber),bankName) != null;

    }
}
