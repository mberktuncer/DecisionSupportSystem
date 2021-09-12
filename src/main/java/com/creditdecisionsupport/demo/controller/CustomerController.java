package com.creditdecisionsupport.demo.controller;

import com.creditdecisionsupport.demo.domain.CustomerDomain;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.creditdecisionsupport.demo.response.DeleteCustomerResponse;
import com.creditdecisionsupport.demo.response.RegisteredBankResponse;
import com.creditdecisionsupport.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController implements CustomerService {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Object>  createCustomer(@RequestBody CustomerDomain customerDomain) throws Exception {

           return customerService.createCustomer(customerDomain);
    }

    @GetMapping("/listAll")
    public List<Customer> listAll(){
        return customerService.listAll();
    }

    @DeleteMapping("/delete/{identityNumber}")
    public ResponseEntity<DeleteCustomerResponse> deleteCustomer(@PathVariable String identityNumber){
        return customerService.deleteCustomer(identityNumber);
    }

    @GetMapping("/list/registered/bank/{identityNo}")
    @Override
    public RegisteredBankResponse getRegisteredBank(@PathVariable String identityNo) {
        return customerService.getRegisteredBank(identityNo);
    }

    @Override
    public Customer getCustomer(String identityNumber) {
        return null;
    }

    @Override
    public boolean isCustomerExist(String identityNumber) {
        return false;
    }

    @Override
    public boolean isCustomerHaveParamBank(String identityNumber, String bankName) {
        return false;
    }

}
