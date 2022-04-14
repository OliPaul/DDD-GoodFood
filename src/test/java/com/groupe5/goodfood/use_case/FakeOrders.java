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
        Dish couscous = new Dish("1", "Couscous", 15.0);
        order1.setId("1");
        order1.setDish(couscous);
        order1.setPrice(20.50);

        orders.put("order-1", order1);
    }




    @Override
    public Order findById(String orderId) {
        return orders.get(orderId);
    }
}
