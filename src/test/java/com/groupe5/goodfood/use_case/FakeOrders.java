package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.model.OrderedDish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeOrders implements OrderRepository {

    Map<String , Order> orders;

    public FakeOrders(){
        orders = new HashMap<>();

        Order order1 = new Order();
        OrderedDish couscous_1 = new OrderedDish("1", "Couscous", 1, 15.0);
        OrderedDish salade_1 = new OrderedDish("5", "Salade", 1, 3.0);
        List<OrderedDish> dishes_1  = new ArrayList<>();
        dishes_1.add(couscous_1);
        dishes_1.add(salade_1);
        order1.setId("1");
        order1.appendDishesToOrder(dishes_1);
        order1.calculateTotalPrice();


        orders.put("1", order1);

        Order order2 = new Order();
        List<OrderedDish> dishes_2  = new ArrayList<>();
        OrderedDish gratinDauphinois = new OrderedDish("2", "Gratin Dauphinois", 1, 10);
        order2.setId("2");
        dishes_2.add(gratinDauphinois);
        order2.appendDishesToOrder(dishes_2);
        order2.calculateTotalPrice();
        orders.put("2", order2);


        Order order3 = new Order();
        List<OrderedDish> dishes_3  = new ArrayList<>();
        OrderedDish sushi = new OrderedDish("3", "Sushi", 1, 9.0);
        order1.setId("3");
        dishes_3.add(sushi);
        order3.appendDishesToOrder(dishes_3);
        order3.calculateTotalPrice();

        orders.put("3", order3);

        Order order4 = new Order();
        List<OrderedDish> dishes_4  = new ArrayList<>();
        OrderedDish couscous_2 = new OrderedDish("4", "Couscous", 1, 15.0);
        order4.setId("4");
        dishes_4.add(couscous_2);
        order4.appendDishesToOrder(dishes_4);
        order4.calculateTotalPrice();

        orders.put("4", order4);


    }

    @Override
    public Order findById(String orderId) {
        return orders.get(orderId);
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public List<OrderedDish> getDishesToOrder(HashMap<String, Integer> selectedDishes, DishRepository dishes) throws DishNotFoundException, EmptyStockException {
        List<OrderedDish> orderedDishList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : selectedDishes.entrySet()) {
            Dish dish = dishes.getDish(entry);
            if (dish == null)
                throw new DishNotFoundException("The dish " + entry.getKey() + " doesn't exist.");

            if (dishes.verifyStock(entry))
                throw new EmptyStockException(dish.getName() + " is out of stock.");

            // Create ordered dish object
            OrderedDish orderDish = new OrderedDish(dish.getId(), dish.getName(), entry.getValue(), dish.getPrice());
            orderedDishList.add(orderDish);
        }
        return orderedDishList;
    }
}
