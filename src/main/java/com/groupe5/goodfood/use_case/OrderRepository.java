package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Order;

public interface OrderRepository {

    Order findById(String orderId);
    void save(Order order);


}
