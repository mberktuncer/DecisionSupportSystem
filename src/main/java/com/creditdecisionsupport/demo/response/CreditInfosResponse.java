package com.creditdecisionsupport.demo.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditInfosResponse {

    private String customerName;
    private String bankName;
    private String creditType;
    private double creditAmount;
    private double interestRate;
    private long expiryDate;
    private List<PaymentDetails> paymentDetails;

}
