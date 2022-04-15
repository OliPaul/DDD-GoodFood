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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

}
