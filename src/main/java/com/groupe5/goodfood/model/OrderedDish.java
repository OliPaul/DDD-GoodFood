package com.groupe5.goodfood.model;

public class OrderedDish {
    private String id;
    private String name;
    private int orderedQuantity;
    private double price;

    public OrderedDish(String id, String name, int orderedQuantity, double price) {
        this.id = id;
        this.name = name;
        this.orderedQuantity = orderedQuantity;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

}
