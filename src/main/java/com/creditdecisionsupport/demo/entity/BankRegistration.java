package com.creditdecisionsupport.demo.entity;

import com.creditdecisionsupport.demo.entity.bank.Bank;
import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date registeredDate = new Date(System.currentTimeMillis());

    private String nameOfBank;

    @OneToMany(mappedBy = "bankRegistration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Credit> credits;

}
