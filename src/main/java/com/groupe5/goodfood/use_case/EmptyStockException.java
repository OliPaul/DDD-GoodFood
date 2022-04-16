package com.groupe5.goodfood.use_case;

public class EmptyStockException extends Exception {
    public EmptyStockException(String message) {
        super(message);
    }
}
