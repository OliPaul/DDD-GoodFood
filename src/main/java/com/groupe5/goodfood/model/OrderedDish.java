package com.groupe5.goodfood.model;

import java.util.Objects;

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

    public double getPrice() {
        return price;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedDish that = (OrderedDish) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
