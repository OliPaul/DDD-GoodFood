package com.groupe5.goodfood.use_case;

public class InvalidCreditCardException extends Exception{
    public InvalidCreditCardException(String message){
        super(message);
    }
}
