package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.model.OrderedDish;

import java.util.HashMap;
import java.util.List;

public interface OrderRepository {

    Order findById(String orderId);
    void save(Order order);
    List<OrderedDish> getDishesToOrder(HashMap<String, Integer> selectedDishes, DishRepository dishes) throws DishNotFoundException, EmptyStockException;

}
