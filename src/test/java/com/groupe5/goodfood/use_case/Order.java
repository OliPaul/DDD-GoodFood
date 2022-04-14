package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.use_case.order.DishRepository;
import com.groupe5.goodfood.use_case.order.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Order {

    private DishRepository dishes;
    private OrderRepository orders;

    @Test
    void find_dish_by_id_should_return_a_dish_if_exist() {

    }
}
