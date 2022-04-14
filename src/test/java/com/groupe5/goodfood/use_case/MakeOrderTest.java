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
        Dish dish = dishes.findById("1");
        assertThat(dish).isInstanceOf(Dish.class);

    }

   @Test
    void order_dish_find_by_id() {
       List<Dish> dishToOrder = new ArrayList<>();
       Dish dish1 = new Dish("1", "couscous", 50.0);
       Dish dish2 = new Dish("2", "salade", 15.0);
       Dish dish3 = new Dish("3", "sushis", 25.0);
       dishToOrder.add(dish1);
       dishToOrder.add(dish2);
       dishToOrder.add(dish3);
       Dish expectedDish1 = dishes.findById("1");
       assertEquals(expectedDish1.getId(), dish1.getId());

       Dish expectedDish2 = dishes.findById("2");
       assertEquals(expectedDish2.getId(), dish2.getId());

       Dish expectedDish3 = dishes.findById("3");
       assertEquals(expectedDish3.getId(), dish3.getId());



   }


}
