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




}
