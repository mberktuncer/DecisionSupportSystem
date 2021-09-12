package com.creditdecisionsupport.demo.entity;

import com.creditdecisionsupport.demo.bankenums.CreditType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private CreditType creditType;
    private double creditAmount;
    private long creditExpiry;
    private double interestRate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "registraiton_id")
    private BankRegistration bankRegistration;

}
