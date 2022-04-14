package com.groupe5.goodfood.use_case.order;

import com.groupe5.goodfood.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish findDishByName(String name);
    List<Dish> findAllDishes();

}
