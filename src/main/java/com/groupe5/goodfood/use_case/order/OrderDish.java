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

    public Order orderDish(){


        List<Dish> orderedDishes = new ArrayList<>();
        Dish  dish = dishes.findById(dishId);
        orderedDishes.add(dish);
        CreditCard card = payments.getCreditCard();










    }

}
