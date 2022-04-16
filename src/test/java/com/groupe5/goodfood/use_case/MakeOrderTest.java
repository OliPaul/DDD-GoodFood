package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.model.OrderedDish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MakeOrderTest {

    private DishRepository dishes;
    private OrderRepository orders;

    @BeforeEach
    public void init() {
        dishes = new FakeDishes();
        orders = new FakeOrders();
    }

    @Test
    void find_dish_by_id_should_return_a_dish_if_exist() {
        Optional<Dish> dish = dishes.findById("1");
        assertThat(dish.get()).isInstanceOf(Dish.class);

    }

    @Test
    void order_dish_find_by_id() {
        List<String> dishToOrder = new ArrayList<>();
        dishToOrder.add("1");
        dishToOrder.add("2");
        dishToOrder.add("3");
        Optional<Dish> expectedDish1 = dishes.findById(dishToOrder.get(0));
        assertThat(expectedDish1.get()).isInstanceOf(Dish.class);

        Optional<Dish> expectedDish2 = dishes.findById(dishToOrder.get(1));
        assertThat(expectedDish2.get()).isInstanceOf(Dish.class);

        Optional<Dish> expectedDish3 = dishes.findById(dishToOrder.get(2));
        assertThat(expectedDish3.get()).isInstanceOf(Dish.class);


    }

    @Test
    void calculate_total_price_should_return_sum_of_ordered_dishes() {
        Order order = new Order();
        List<OrderedDish> orderedDishes = new ArrayList<>();
        OrderedDish sushi = new OrderedDish("1", "Sushi", 1, 5);
        OrderedDish gratinDauphinois = new OrderedDish("2", "Gratin Dauphinois", 1, 10);
        orderedDishes.add(sushi);
        orderedDishes.add(gratinDauphinois);

        order.appendDishesToOrder(orderedDishes);

        order.calculateTotalPrice();
        assertEquals(15, order.getPrice());

    }

    @Test
    void update_stock_should_return_a_stock_with_quantity_reduced(){

        Order order = new Order();
        List<OrderedDish> orderedDishes = new ArrayList<>();
        Dish sushiDish = new Dish("1", "Sushi", 1, 5);
        Dish gratinDauphinoisDish = new Dish("2", "Gratin Dauphinois", 10, 10);

        OrderedDish sushi = new OrderedDish("1", "Sushi", 1, 5);
        OrderedDish gratinDauphinois = new OrderedDish("2", "Gratin Dauphinois", 3, 10);
        orderedDishes.add(sushi);
        orderedDishes.add(gratinDauphinois);

        order.appendDishesToOrder(orderedDishes);
        sushiDish.updateStock(sushi);
        assertEquals(4 , sushiDish.getQuantity());
        gratinDauphinoisDish.updateStock(gratinDauphinois);
        assertEquals(7, gratinDauphinoisDish.getQuantity());








    }




}
