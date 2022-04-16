package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void order_dish_that_not_exist_should_throw_exception () {
        HashMap<String, Integer> dishesToOrder = new HashMap<>() {{
            put("10", 2);
            put("1", 1);
        }};
        List<Dish> dishList = dishes.getAll();

        Exception exception = assertThrows(DishNotFoundException.class, () -> {
            orderDish(dishesToOrder, dishList);
        });

        String expectedMessage = "The dish 10 doesn't exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    private Order orderDish(HashMap<String, Integer> selectedDishes, List<Dish> dishList) throws InvalidCreditCardException, InsufficientFundsException, EmptyStockException, DishNotFoundException {
        OrderDish order = new OrderDish(orders, dishes, payments);
        return order.orderDish(selectedDishes, dishList);
    }
}
