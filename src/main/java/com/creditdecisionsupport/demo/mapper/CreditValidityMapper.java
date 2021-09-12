package com.creditdecisionsupport.demo.mapper;

import com.creditdecisionsupport.demo.constants.CreditBoundConstants;
import com.creditdecisionsupport.demo.constants.CreditValidationRejectMessages;

public class CreditValidityMapper {

    public static boolean checkCreditValidity(String creditType,Double creditAmount){

        boolean isValid = false;

        switch (creditType){

            case "STUDENT":
                isValid = (creditAmount > CreditBoundConstants.MIN_STUDENT_CREDIT && creditAmount <CreditBoundConstants.MAX_STUDENT_CREDIT);
                break;

            case "PERSONAL":
                isValid = (creditAmount > CreditBoundConstants.MIN_PERSONAL_CREDIT && creditAmount <CreditBoundConstants.MAX_PERSONAL_CREDIT);
                break;

            case "TRANSPORT":
                isValid = (creditAmount > CreditBoundConstants.MIN_TRANSPORT_CREDIT && creditAmount <CreditBoundConstants.MAX_TRANSPORT_CREDIT);
                break;

            case "ARTISAN":
                isValid = (creditAmount > CreditBoundConstants.MIN_ARTISAN_CREDIT && creditAmount <CreditBoundConstants.MAX_ARTISAN_CREDIT);
                break;

            case "MARRIAGE":
                isValid = (creditAmount > CreditBoundConstants.MIN_MARRIAGE_CREDIT && creditAmount <CreditBoundConstants.MAX_MARRIAGE_CREDIT);
                break;

            case "HOUSING":
                isValid = (creditAmount > CreditBoundConstants.MIN_HOUSING_CREDIT && creditAmount <CreditBoundConstants.MAX_HOUSING_CREDIT);
                break;
            default:
                isValid = true;

        }

        return isValid;

    }

    public static String returnRejectedMessage(String reason){

        String message = "";

        switch (reason){

            case "CUSTOMER_NOT_FOUND":
                message = CreditValidationRejectMessages.CUSTOMER_NOT_FOUND;
                break;

            case "BANK_NOT_HAVE_CUSTOMER":
                message = CreditValidationRejectMessages.BANK_NOT_HAVE_CUSTOMER;
                break;

            case "AMOUNT_ERROR":
                message = CreditValidationRejectMessages.AMOUNT_ERROR;
                break;

        }
        return message;
    }
}
