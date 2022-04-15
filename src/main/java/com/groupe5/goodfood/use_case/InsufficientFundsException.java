package com.groupe5.goodfood.use_case;

public class InsufficientFundsException extends Exception{

    public InsufficientFundsException(String message){
        super(message);
    }
}
