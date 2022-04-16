package com.groupe5.goodfood.use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderDishTest {

    PaymentRepository payments;
    OrderRepository orders;
    DishRepository dishes;

    @BeforeEach
    public void init() {
        payments = new FakeCreditCard();
        orders = new FakeOrders();
        dishes = new FakeDishes();
    }

    @Test
    void order_dish() {

    }
}
