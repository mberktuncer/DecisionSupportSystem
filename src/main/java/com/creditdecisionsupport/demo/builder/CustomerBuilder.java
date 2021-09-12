package com.creditdecisionsupport.demo.builder;

import com.creditdecisionsupport.demo.domain.CustomerDomain;
import com.creditdecisionsupport.demo.entity.customer.Customer;

public class CustomerBuilder {

    public static Customer buildCustomer(CustomerDomain customerDomain){

        return Customer.builder()
                .identityNumber(customerDomain.getIdentityNumber())
                .name(customerDomain.getName())
                .lastName(customerDomain.getLastName())
                .build();
    }

}
