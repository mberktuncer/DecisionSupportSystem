package com.creditdecisionsupport.demo.params;

import com.creditdecisionsupport.demo.bankenums.CreditType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TakeCreditParams {

    private CreditType creditType;
    private double creditAmount;

    @JsonIgnore
    private long creditExpiry;
    @JsonIgnore
    private double interestRate;

    private String identityNumber;
    private String nameOfBank;

}
