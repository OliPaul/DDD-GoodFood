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

    public Order orderDish(HashMap<String, Integer> selectedDishes) throws InvalidCreditCardException, InsufficientFundsException {
        Order order = new Order();
        double totalAmount = 0;
        List<Dish> dishList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : selectedDishes.entrySet()) {
            //Récuperer le plat par son id
            Optional<Dish> optionalDish = dishes.findById(entry.getKey());
            //si le plat n'existe pas on notifie l'utilisateur
            if (optionalDish.isEmpty()) {
                // notify user
                break;
            }
            Dish dish = optionalDish.get();
            dishList.add(dish);
            //Vérification de stock
            if (dish.getQuantity() < entry.getValue()) {
                // notify user stock pas dispo
                break;
            }
            //ajouter les plat à la commande

            OrderedDish orderDish = new OrderedDish(dish.getId(), dish.getName(), entry.getValue(), dish.getPrice());
            order.appendDishToOrder(orderDish);
        }
        // calculer le total de la commande
        order.calculateTotalPrice();
        CreditCard card = payments.getCreditCard();
        // Vérifier la validité de la carte de crédit
        if (!card.validCreditCard()) {
            throw new InvalidCreditCardException("Invalid Credit card ");
        }
        // Valider le paiement
        if (card.validatePayment(order)) {
            throw new InsufficientFundsException("Card balance insufficient");
        }
        // Enregistrer la commande
        orders.save(order);
        // mise à jour du stock

        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);

            dish.updateStock(order.getDishes().get(i));
        }
        //mise à jour de la balance
        card.updateBalance(totalAmount);
        return order;

    }


}
