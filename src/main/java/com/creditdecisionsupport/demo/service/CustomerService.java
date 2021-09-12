package com.creditdecisionsupport.demo.service;

import com.creditdecisionsupport.demo.domain.CustomerDomain;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.creditdecisionsupport.demo.response.DeleteCustomerResponse;
import com.creditdecisionsupport.demo.response.RegisteredBankResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    public ResponseEntity<Object> createCustomer(CustomerDomain customerDomain) throws Exception;
    public List<Customer> listAll();
    public ResponseEntity<DeleteCustomerResponse> deleteCustomer(String identityNumber);
    public RegisteredBankResponse getRegisteredBank(String identityNo);
    public Customer getCustomer(String identityNumber);
    public boolean isCustomerExist(String identityNumber);
    public boolean isCustomerHaveParamBank(String identityNumber,String bankName);

}
