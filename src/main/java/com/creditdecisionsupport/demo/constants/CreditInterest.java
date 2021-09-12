package com.creditdecisionsupport.demo.constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditInterest implements InterestRate{

    @Override
    public double getInterestRate(String bankName, String creditType) {

        switch (bankName){

            case "Akbank":
                return BankCreditInterest.getAkbankCreditInterest(creditType);
            case "AlbarakaTurk":
                return BankCreditInterest.getAlbarakaTurkCreditInterest(creditType);
            case "Denizbank":
                return BankCreditInterest.getDenizBankCreditInterest(creditType);
            case "Fibabanka":
                return BankCreditInterest.getFibabankaCreditInterest(creditType);
            case "GarantiBBVA":
                return BankCreditInterest.getGarantiBBVACreditInterest(creditType);
            case "Isbank":
                return BankCreditInterest.getIsbankCreditInterest(creditType);
            case "KuveytTurk":
                return BankCreditInterest.getKuveytTurkCreditInterest(creditType);
            default:
                throw new IllegalStateException("Unexpected value: " + bankName);
        }

    }
}
