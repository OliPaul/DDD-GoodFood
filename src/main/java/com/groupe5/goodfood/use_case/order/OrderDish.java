package com.groupe5.goodfood.use_case.order;

import com.groupe5.goodfood.model.CreditCard;
import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.use_case.payment.PaymentRepository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDish {

    private final OrderRepository orders;
    private final DishRepository dishes;
    private final PaymentRepository payments;


    public OrderDish(OrderRepository orders, DishRepository dishes, PaymentRepository payments){

        this.orders = orders;
        this.dishes = dishes;
        this.payments = payments;
    }

    public Order orderDish(HashMap<String, Integer> selectedDishes) throws InvalidCreditCardException, InsufficientFundsException {




        double sum = 0;
        for(Map.Entry<String, String> entry: selectedDishes.entrySet()){

            Dish dish = dishes.findById()


        }

        for (Dish dish : toBeOrderedDishes){
            sum += dish.getPrice();
        }
        Order order = getOrder(orderId, sum, toBeOrderedDishes);
        CreditCard card = payments.getCreditCard();
        if(!card.validCreditCard()){
            throw  new InvalidCreditCardException("Invalid Credit card ");
        }
        if(card.validatePayment()){
            throw new InsufficientFundsException("Card balance insufficient");
        }
        card.updateBalance(sum);


        orders.save(order);
        return order;

    }

    public Order getOrder(String orderId, double sum, List<Dish> dishesToOrder){
        Order order = new Order();

        order.setId(orderId);
        order.setPrice(sum);
        order.setDishes(dishesToOrder);

        return order;
    }



}
