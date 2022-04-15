package com.groupe5.goodfood.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private List<OrderedDish> dishes = new ArrayList<>();
    private double price;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderedDish> getDishes() {
        return this.dishes;
    }

    public void setDishes(List<Dish> dish) {
        this.dishes = dishes;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void appendDishToOrder(OrderedDish orderedDish) {
        dishes.add(orderedDish);
    }

    public void calculateTotalPrice() {
        double totalAmount = 0;
        for (OrderedDish orderedDish : dishes) {
            totalAmount += orderedDish.getPrice() * orderedDish.getOrderedQuantity();
        }

        price = totalAmount;
    }
}
