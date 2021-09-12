package com.creditdecisionsupport.demo.repository.bank;

import com.creditdecisionsupport.demo.entity.bank.Bank;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface BankRepository extends JpaRepository<Bank,Long> {

    public Bank findByName(String name);

}
