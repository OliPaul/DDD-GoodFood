package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.CreditCard;
import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.model.OrderedDish;


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
        Order order = new Order();
        List<OrderedDish> orderedDishList = orders.getDishesToOrder(selectedDishes, dishes);
        //ajouter les plats à la commande
        order.appendDishesToOrder(orderedDishList);
        // calculer le total de la commande
        order.calculateTotalPrice();

        creditCard.pay(order);
        // Enregistrer la commande
        orders.save(order);
        // Mettre à jour le stock des plats commandés
        order.updateDishesQuantity(dishList, order);
        //mise à jour de la balance
        creditCard.updateBalance(order.getPrice());
        return order;

    }

}
