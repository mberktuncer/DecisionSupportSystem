package com.creditdecisionsupport.demo.constants;

public class BankCreditInterest {

    public static double getAkbankCreditInterest(String creditType){

        double interestRate;

        switch (creditType){
            case "PERSONEL":
                interestRate = 1.65;
                break;
            case "HOUSING":
                interestRate = 1.45;
                break;
            case "TRANSPORT":
                interestRate = 1.40;
                break;
            case "MARRIAGE":
                interestRate = 1.41;
                break;
            case "ARTISAN":
                interestRate = 1.51;
                break;
            case "STUDENT":
                interestRate = 1.30;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + creditType);
        }

        return interestRate;

    }

    public static double getAlbarakaTurkCreditInterest(String creditType){

        double interestRate;

        switch (creditType){
            case "PERSONEL":
                interestRate = 1.64;
                break;
            case "HOUSING":
                interestRate = 1.45;
                break;
            case "TRANSPORT":
                interestRate = 1.40;
                break;
            case "MARRIAGE":
                interestRate = 1.41;
                break;
            case "ARTISAN":
                interestRate = 1.51;
                break;
            case "STUDENT":
                interestRate = 1.35;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + creditType);
        }

        return interestRate;

    }

    public static double getDenizBankCreditInterest(String creditType){

        double interestRate;

        switch (creditType){
            case "PERSONEL":
                interestRate = 1.64;
                break;
            case "HOUSING":
                interestRate = 1.55;
                break;
            case "TRANSPORT":
                interestRate = 1.40;
                break;
            case "MARRIAGE":
                interestRate = 1.41;
                break;
            case "ARTISAN":
                interestRate = 1.51;
                break;
            case "STUDENT":
                interestRate = 1.35;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + creditType);
        }

        return interestRate;

    }

    public static double getFibabankaCreditInterest(String creditType){

        double interestRate;

        switch (creditType){
            case "PERSONEL":
                interestRate = 1.64;
                break;
            case "HOUSING":
                interestRate = 1.45;
                break;
            case "TRANSPORT":
                interestRate = 1.40;
                break;
            case "MARRIAGE":
                interestRate = 1.44;
                break;
            case "ARTISAN":
                interestRate = 1.51;
                break;
            case "STUDENT":
                interestRate = 1.35;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + creditType);
        }

        return interestRate;

    }

    public static double getGarantiBBVACreditInterest(String creditType){

        double interestRate;

        switch (creditType){
            case "PERSONEL":
                interestRate = 1.64;
                break;
            case "HOUSING":
                interestRate = 1.45;
                break;
            case "TRANSPORT":
                interestRate = 1.42;
                break;
            case "MARRIAGE":
                interestRate = 1.41;
                break;
            case "ARTISAN":
                interestRate = 1.51;
                break;
            case "STUDENT":
                interestRate = 1.35;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + creditType);
        }

        return interestRate;

    }

    public static double getIsbankCreditInterest(String creditType){

        double interestRate;

        switch (creditType){
            case "PERSONEL":
                interestRate = 1.64;
                break;
            case "HOUSING":
                interestRate = 1.45;
                break;
            case "TRANSPORT":
                interestRate = 1.40;
                break;
            case "MARRIAGE":
                interestRate = 1.41;
                break;
            case "ARTISAN":
                interestRate = 1.51;
                break;
            case "STUDENT":
                interestRate = 1.34;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + creditType);
        }

        return interestRate;

    }

    public static double getKuveytTurkCreditInterest(String creditType){

        double interestRate;

        switch (creditType){
            case "PERSONEL":
                interestRate = 1.64;
                break;
            case "HOUSING":
                interestRate = 1.45;
                break;
            case "TRANSPORT":
                interestRate = 1.40;
                break;
            case "MARRIAGE":
                interestRate = 1.41;
                break;
            case "ARTISAN":
                interestRate = 1.58;
                break;
            case "STUDENT":
                interestRate = 1.35;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + creditType);
        }

        return interestRate;

    }
}
