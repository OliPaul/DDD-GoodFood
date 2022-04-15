package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.use_case.order.DishRepository;
import com.groupe5.goodfood.use_case.order.OrderRepository;
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


}
