package com.creditdecisionsupport.demo.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class RegisteredBankInfo {

    private String bank;

    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date registeredDate;

    private String customerNumber;

}
