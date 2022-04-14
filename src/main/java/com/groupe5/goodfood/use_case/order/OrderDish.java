package com.groupe5.goodfood.use_case.order;

import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDish {

    private final OrderRepository orders;
    private final DishRepository dishes;

    public OrderDish(OrderRepository orders, DishRepository dishes){

        this.orders = orders;
        this.dishes = dishes;
    }

}
