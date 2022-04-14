package com.groupe5.goodfood.use_case.order;

import com.groupe5.goodfood.model.Dish;

import java.util.Optional;

public interface DishRepository {
    Dish findById(String dishId);


}
