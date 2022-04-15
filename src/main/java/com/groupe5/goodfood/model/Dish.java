package com.groupe5.goodfood.model;

public class Dish {
    private String id;
    private String name;
    private double price;
    private int quantity;


    public Dish(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return quantity;
    }


    public void updateStock(OrderedDish orderedDish){
        quantity -= orderedDish.getOrderedQuantity();
    }
}
