package com.groupe5.goodfood.model;

import java.util.List;
import java.util.Objects;

public class Order {

    private String id;
    private List<OrderedDish> dishes;
    private double price;


    public double getPrice() {
        return price;
    }

    public List<OrderedDish> getDishes() {
        return this.dishes;
    }

    public void setDishes(List<OrderedDish> orderedDishes) {
        dishes = orderedDishes;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void appendDishesToOrder(List<OrderedDish> orderedDishes) {
        dishes = orderedDishes;
    }

    public void calculateTotalPrice() {
        double totalAmount = 0;
        for (OrderedDish orderedDish : dishes) {
            totalAmount += orderedDish.getPrice() * orderedDish.getOrderedQuantity();
        }

        price = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.price, price) == 0 && Objects.equals(id, order.id) && dishes.equals(order.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishes, price);
    }
}
