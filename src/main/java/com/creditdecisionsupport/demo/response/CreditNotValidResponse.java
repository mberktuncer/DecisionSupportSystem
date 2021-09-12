package com.creditdecisionsupport.demo.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditNotValidResponse {

    private String rejectionReason;
    private int approve;
    private String nameOfBank;
    private Date applyDate;
    private String customerName;
    private String customerSurname;
    private String identityNo;
    private double rejectedAmount;
    private String creditType;

}
