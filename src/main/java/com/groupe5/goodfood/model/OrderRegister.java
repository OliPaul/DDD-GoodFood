package com.groupe5.goodfood.model;

import com.groupe5.goodfood.use_case.InsufficientFundsException;
import com.groupe5.goodfood.use_case.InvalidCreditCardException;
import com.groupe5.goodfood.use_case.OrderRepository;

import java.util.List;

// Domain service
public class OrderRegister {
    public Order proceedOrder(List<OrderedDish> orderedDishList, CreditCard creditCard, OrderRepository orders) throws InvalidCreditCardException, InsufficientFundsException {
        Order order = new Order();
        //ajouter les plats à la commande
        order.appendDishesToOrder(orderedDishList);
        // calculer le total de la commande
        order.calculateTotalPrice();
        // Payer la commande
        creditCard.pay(order);
        // Enregistrer la commande
        orders.save(order);
        return order;
    }
}
