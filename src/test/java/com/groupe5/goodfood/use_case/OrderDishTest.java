package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.CreditCard;
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
    void order_dish_that_not_exist_should_throw_dish_not_found_exception () {
        HashMap<String, Integer> dishesToOrder = new HashMap<>() {{
            put("10", 2);
            put("1", 1);
        }};
        List<Dish> dishList = dishes.getAll();
        CreditCard creditCard = payments.getCreditCard();

        Exception exception = assertThrows(DishNotFoundException.class, () -> {
            orderDish(dishesToOrder, dishList, creditCard);
        });

        String expectedMessage = "The dish 10 doesn't exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void order_dish_with_quantity_greater_dish_stock_should_throw_empty_stock_exception () {
        HashMap<String, Integer> dishesToOrder = new HashMap<>() {{
            put("2", 100);
            put("1", 1);
        }};
        List<Dish> dishList = dishes.getAll();
        CreditCard creditCard = payments.getCreditCard();

        Exception exception = assertThrows(EmptyStockException.class, () -> {
            orderDish(dishesToOrder, dishList, creditCard);
        });

        String expectedMessage = "salade is out of stock.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void order_dish_with_expired_credit_card_should_throw_invalid_credit_card_exception () {
        HashMap<String, Integer> dishesToOrder = new HashMap<>() {{
            put("2", 1);
            put("1", 1);
        }};
        CreditCard creditCard = payments.getExpiredCreditCard();
        List<Dish> dishList = dishes.getAll();

        Exception exception = assertThrows(InvalidCreditCardException.class, () -> {
            orderDish(dishesToOrder, dishList, creditCard);
        });

        String expectedMessage = "Invalid Credit card";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    private Order orderDish(HashMap<String, Integer> selectedDishes, List<Dish> dishList, CreditCard card) throws InvalidCreditCardException, InsufficientFundsException, EmptyStockException, DishNotFoundException {
        OrderDish order = new OrderDish(orders, dishes, payments);
        return order.orderDish(selectedDishes, dishList, card);
    }
}
