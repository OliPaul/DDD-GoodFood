package com.groupe5.goodfood.use_case.order;

import com.groupe5.goodfood.model.CreditCard;
import com.groupe5.goodfood.model.Dish;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.use_case.payment.PaymentRepository;


import java.util.ArrayList;
import java.util.List;

public class OrderDish {

    private final OrderRepository orders;
    private final DishRepository dishes;
    private final PaymentRepository payments;





    public OrderDish(OrderRepository orders, DishRepository dishes, PaymentRepository payments){

        this.orders = orders;
        this.dishes = dishes;
        this.payments = payments;
    }

    public Order orderDish(List<Dish> selectedDishes, String orderId) throws InvalidCreditCardException, InsufficientFundsException {
        List<Dish> toBeOrderedDishes = new ArrayList<>();
        for(Dish dish:  selectedDishes){
            Dish  dishTobeOrdered = dishes.findById(dish.getId());
            toBeOrderedDishes.add(dishTobeOrdered);
        }

        double sum = 0;
        for (Dish dish : toBeOrderedDishes){
            sum += dish.getPrice();
        }

        CreditCard card = payments.getCreditCard();
        if(!card.validCreditCard()){
            throw  new InvalidCreditCardException("Invalid Credit card ");
        }
        if(card.getBalance() < sum){
            throw new InsufficientFundsException("Card balance insufficient");
        }

        Order order = getOrder(orderId, sum, toBeOrderedDishes);
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
