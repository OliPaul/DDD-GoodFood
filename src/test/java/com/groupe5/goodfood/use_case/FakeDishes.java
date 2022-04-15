package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.use_case.order.DishRepository;
import com.groupe5.goodfood.use_case.order.OrderRepository;

import java.util.*;

public class FakeDishes implements DishRepository {
    Map<String, Dish> dishes;

    public FakeDishes() {
        dishes = new HashMap<>();

        Dish couscous = new Dish("1", "couscous", 50.0, 10);
        dishes.put("1", couscous);
        Dish salade = new Dish("2", "salade", 15.0, 5);
        dishes.put("2", salade);
        Dish sushis = new Dish("3", "sushis", 25.0, 3);
        dishes.put("3", sushis);
        Dish poulet = new Dish("4", "poulet", 6.0, 20);
        dishes.put("4", poulet);
        Dish ratatouille = new Dish("5", "ratatouille", 16.0, 8);
        dishes.put("5", ratatouille);

    }
        @Override
        public Optional<Dish> findById(String dishId){
            return Optional.ofNullable(dishes.get(dishId));
        }

}
