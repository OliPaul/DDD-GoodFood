package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.use_case.order.OrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeOrders implements OrderRepository {

    Map<String , Order> orders;

    public FakeOrders(){
        orders = new HashMap<>();

        Order order1 = new Order();
        Dish couscous_1 = new Dish("1", "Couscous", 15.0);
        Dish salade_1 = new Dish("5", "Salade", 3);
        List<Dish> dishes_1  = new ArrayList<>();
        dishes_1.add(couscous_1);
        dishes_1.add(salade_1);
        order1.setId("1");
        order1.setDishes(dishes_1);
        order1.setPrice(17.0);

        orders.put("1", order1);

        Order order2 = new Order();
        List<Dish> dishes_2  = new ArrayList<>();
        Dish gratinDauphinois = new Dish("2", "Gratin Dauphinois", 10);
        order2.setId("2");
        dishes_2.add(gratinDauphinois);
        order2.setDishes(dishes_2);
        order2.setPrice(11.50);
        orders.put("2", order2);


        Order order3 = new Order();
        List<Dish> dishes_3  = new ArrayList<>();
        Dish sushi = new Dish("3", "Sushi", 9.0);
        order1.setId("3");
        dishes_3.add(sushi);
        order1.setDishes(dishes_3);
        order1.setPrice(10.50);

        orders.put("3", order3);

        Order order4 = new Order();
        List<Dish> dishes_4  = new ArrayList<>();
        Dish couscous_2 = new Dish("4", "Couscous", 15.0);
        order1.setId("4");
        dishes_4.add(couscous_2);
        order1.setDishes(dishes_4);
        order1.setPrice(17.0);

        orders.put("4", order4);


    }

    @Override
    public Order findById(String orderId) {
        return orders.get(orderId);
    }
}
