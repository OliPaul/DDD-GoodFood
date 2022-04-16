package com.groupe5.goodfood.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.price, price) == 0 && quantity == dish.quantity && Objects.equals(id, dish.id) && name.equals(dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }
}
