package com.groupe5.goodfood.use_case.order;

import com.groupe5.goodfood.model.Dish;

public interface OrderRepository {
    Dish findById();
}
