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
        List<OrderedDish> orderedDishList = getDishesToOrder(selectedDishes);
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

    private List<OrderedDish> getDishesToOrder(HashMap<String, Integer> selectedDishes) throws DishNotFoundException, EmptyStockException {
        List<OrderedDish> orderedDishList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : selectedDishes.entrySet()) {
            Dish dish = dishes.getDish(entry);
            if (dish == null)
                throw new DishNotFoundException("The dish " + entry.getKey() + " doesn't exist.");

            if (verifyStock(entry, dish))
                throw new EmptyStockException(dish.getName() + " is out of stock.");

            // Create ordered dish object
            OrderedDish orderDish = new OrderedDish(dish.getId(), dish.getName(), entry.getValue(), dish.getPrice());
            orderedDishList.add(orderDish);
        }
        return orderedDishList;
    }

    private boolean verifyStock(Map.Entry<String, Integer> entry, Dish dish) {
        //Vérification de stock
        // notify user stock pas dispo
        return dish.getQuantity() < entry.getValue();
    }

}
