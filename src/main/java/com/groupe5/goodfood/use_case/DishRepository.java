package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DishRepository {
    Optional<Dish> findById(String dishId);
    List<Dish> getAll();
    Dish getDish(Map.Entry<String, Integer> entry);
}
