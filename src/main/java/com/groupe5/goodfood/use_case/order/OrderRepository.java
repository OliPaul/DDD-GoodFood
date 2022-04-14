package com.groupe5.goodfood.use_case.order;

import com.groupe5.goodfood.model.Order;

public interface OrderRepository {
    Order findById(String orderId);
}
