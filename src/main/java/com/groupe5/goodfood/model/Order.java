package com.groupe5.goodfood.model;

public class Order {

    private String id;
    private Dish dish;
    private double price;


    public Order(String id, Dish dish, double price) {
        this.id = id;
        this.dish = dish;
        this.price = price;
    }

    public Order() {

    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
