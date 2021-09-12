package com.creditdecisionsupport.demo.repository;

import com.creditdecisionsupport.demo.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByIdentityNumber(String identityNumber);

}
