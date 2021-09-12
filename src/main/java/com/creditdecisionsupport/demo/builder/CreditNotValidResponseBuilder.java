package com.creditdecisionsupport.demo.builder;

import com.creditdecisionsupport.demo.entity.customer.Customer;
import com.creditdecisionsupport.demo.mapper.CreditValidityMapper;
import com.creditdecisionsupport.demo.params.TakeCreditParams;
import com.creditdecisionsupport.demo.response.CreditNotValidResponse;

import java.util.Date;

public class CreditNotValidResponseBuilder {

    public static CreditNotValidResponse generateNotValidResponse(TakeCreditParams params, String reason, Customer customer,int approve){

        return CreditNotValidResponse.builder()
                .creditType(params.getCreditType().toString())
                .applyDate(new Date(System.currentTimeMillis()))
                .rejectionReason(CreditValidityMapper.returnRejectedMessage(reason))
                .nameOfBank(params.getNameOfBank())
                .rejectedAmount(params.getCreditAmount())
                .customerName(customer.getName())
                .customerSurname(customer.getLastName())
                .approve(approve)
                .identityNo(customer.getIdentityNumber())
                .build();

    }

}
