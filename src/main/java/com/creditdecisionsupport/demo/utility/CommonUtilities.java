package com.creditdecisionsupport.demo.utility;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CommonUtilities {

    public String generateCustomerNumber(){
        Random rnd = new Random();

        StringBuilder customerNumber = new StringBuilder();
        for (int i = 0; i < 10; i++){
            int generatedNumber = rnd.nextInt(9);
            customerNumber.append(generatedNumber);
        }
        return String.valueOf(customerNumber);
    }

}
