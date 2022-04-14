package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.use_case.order.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public class FakeOrders implements OrderRepository {

    Map<String , Order> orders;

    public FakeOrders(){
        orders = new HashMap<>();

        Order order1 = new Order();
        Dish couscous_1 = new Dish("1", "Couscous", 15.0);
        order1.setId("1");
        order1.setDish(couscous_1);
        order1.setPrice(17.0);

        orders.put("1", order1);

        Order order2 = new Order();
        Dish gratinDauphinois = new Dish("2", "Gratin Dauphinois", 10);
        order2.setId("2");
        order2.setDish(gratinDauphinois);
        order2.setPrice(11.50);
        orders.put("2", order2);


        Order order3 = new Order();
        Dish sushi = new Dish("3", "Sushi", 9.0);
        order1.setId("3");
        order1.setDish(sushi);
        order1.setPrice(10.50);

        orders.put("3", order3);

        Order order4 = new Order();
        Dish couscous_2 = new Dish("4", "Couscous", 15.0);
        order1.setId("4");
        order1.setDish(couscous_2);
        order1.setPrice(17.0);

        orders.put("4", order4);



    }

    @Override
    public Order findById(String orderId) {
        return orders.get(orderId);
    }
}
