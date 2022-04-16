package com.groupe5.goodfood.use_case;

public class DishNotFoundException extends Exception {
    public DishNotFoundException(String message) {
        super(message);
    }
}
