package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;

import java.util.*;

public class FakeDishes implements DishRepository {
    Map<String, Dish> dishes;
    List<Dish> dishList;

    public FakeDishes() {
        dishes = new HashMap<>();
        dishList = new ArrayList<>();

        Dish couscous = new Dish("1", "couscous", 50.0, 10);
        dishes.put("1", couscous);
        dishList.add(couscous);
        Dish salade = new Dish("2", "salade", 15.0, 5);
        dishes.put("2", salade);
        dishList.add(salade);
        Dish sushis = new Dish("3", "sushis", 25.0, 3);
        dishes.put("3", sushis);
        dishList.add(sushis);
        Dish poulet = new Dish("4", "poulet", 6.0, 20);
        dishes.put("4", poulet);
        dishList.add(poulet);
        Dish ratatouille = new Dish("5", "ratatouille", 16.0, 8);
        dishes.put("5", ratatouille);
        dishList.add(ratatouille);

    }

    @Override
    public Optional<Dish> findById(String dishId) {
        return Optional.ofNullable(dishes.get(dishId));
    }

    @Override
    public List<Dish> getAll() {
        return dishList;
    }

}
