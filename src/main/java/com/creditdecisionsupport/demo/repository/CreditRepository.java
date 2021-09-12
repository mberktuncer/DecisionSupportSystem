package com.creditdecisionsupport.demo.repository;

import com.creditdecisionsupport.demo.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {
}
