package com.creditdecisionsupport.demo.repository;

import com.creditdecisionsupport.demo.entity.BankRegistration;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRegistrationRepository extends JpaRepository<BankRegistration,Long> {

    public BankRegistration findByCustomerAndNameOfBank(Customer customer,String nameOfBank);

}
