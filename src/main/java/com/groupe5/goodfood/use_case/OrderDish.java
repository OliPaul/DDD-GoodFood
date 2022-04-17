package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.*;


import java.util.*;

public class OrderDish {

    private final OrderRepository orders;
    private final DishRepository dishes;
    private final PaymentRepository payments;


    public OrderDish(OrderRepository orders, DishRepository dishes, PaymentRepository payments) {

        this.orders = orders;
        this.dishes = dishes;
        this.payments = payments;
    }

    public Order orderDish(HashMap<String, Integer> selectedDishes, List<Dish> dishList, CreditCard creditCard) throws InvalidCreditCardException, InsufficientFundsException, DishNotFoundException, EmptyStockException {
        List<OrderedDish> orderedDishList = orders.getDishesToOrder(selectedDishes, dishes);
        // Passer la commande (Domain service)
        Order order = new OrderRegister().proceedOrder(orderedDishList, creditCard, orders);
        // Mettre à jour le stock des plats commandés
        order.updateDishesQuantity(dishList, order);
        //mise à jour de la balance
        creditCard.updateBalance(order.getPrice());
        return order;

    }

}
