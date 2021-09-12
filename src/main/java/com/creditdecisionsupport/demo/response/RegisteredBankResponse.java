package com.creditdecisionsupport.demo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegisteredBankResponse {
    private String customerName;
    private String customerLastname;
    private List<RegisteredBankInfo> registeredBankInfoList;
}
