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

    public Order orderDish(HashMap<String, Integer> selectedDishes, List<Dish> dishList, CreditCard card) throws InvalidCreditCardException, InsufficientFundsException, DishNotFoundException, EmptyStockException {
        Order order = new Order();
        double totalAmount = 0;
        List<OrderedDish> orderedDishList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : selectedDishes.entrySet()) {
            Dish dish = getDish(entry);
            if (dish == null)
                throw new DishNotFoundException("The dish " + entry.getKey() + " doesn't exist.");

            if (verifyStock(entry, dish))
                throw new EmptyStockException(dish.getName() + " is out of stock.");

            // Create ordered dish object
            OrderedDish orderDish = new OrderedDish(dish.getId(), dish.getName(), entry.getValue(), dish.getPrice());
            orderedDishList.add(orderDish);
        }
        //ajouter les plat à la commande
        order.appendDishesToOrder(orderedDishList);
        // calculer le total de la commande
        order.calculateTotalPrice();

        // Vérifier la validité de la carte de crédit
        if (!card.validCreditCard()) {
            throw new InvalidCreditCardException("Invalid Credit card");
        }
        // Valider le paiement
        if (card.validatePayment(order)) {
            throw new InsufficientFundsException("Card balance insufficient");
        }
        // mise à jour du stock
        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);
            for (OrderedDish orderedDish : orderedDishList){
                if(dish.getId().equals(orderedDish.getId())) {
                    dish.updateStock(order.getDishes().get(i));
                }
            }
        }
        // Enregistrer la commande
        orders.save(order);
        //mise à jour de la balance
        card.updateBalance(totalAmount);
        return order;

    }

    private boolean verifyStock(Map.Entry<String, Integer> entry, Dish dish) {
        //Vérification de stock
        // notify user stock pas dispo
        return dish.getQuantity() < entry.getValue();
    }

    private Dish getDish(Map.Entry<String, Integer> entry) {
        //Récuperer le plat par son id
        Optional<Dish> optionalDish = dishes.findById(entry.getKey());
        //si le plat n'existe pas on notifie l'utilisateur
        if (optionalDish.isEmpty()) {
            // notify user
            return null;
        }
        return optionalDish.get();
    }


}
