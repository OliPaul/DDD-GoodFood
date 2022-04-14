package com.groupe5.goodfood.use_case.order;

import com.groupe5.goodfood.model.Dish;

public interface DishRepository {
    Dish findById(String dishId);
}
