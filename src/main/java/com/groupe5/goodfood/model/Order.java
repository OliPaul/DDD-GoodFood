package com.groupe5.goodfood.model;

import java.util.List;

public class Order {

    private String id;
    private List<Dish> dishes;
    private double price;


    public Order() {

    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Dish> getDishes() {
        return this.dishes;
    }

    public void setDishes(List<Dish> dish) {
        this.dishes = dishes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
