package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.CreditCard;
import com.groupe5.goodfood.model.Order;
import com.groupe5.goodfood.use_case.order.OrderRepository;
import com.groupe5.goodfood.use_case.payment.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Payment {

    PaymentRepository paymentRepository;
    OrderRepository orderRepository;

    @BeforeEach
    public void init() {
        paymentRepository = new FakeCreditCard();
        orderRepository = new FakeOrders();
    }

    @Test
    void check_credit_card_should_return_true_if_expiration_date_is_valid() {
        CreditCard creditCard = paymentRepository.getCreditCard();
        // Check if credit card is valid
        assertThat(creditCard.validCreditCard()).isTrue();
    }

    @Test
    void validate_payment_if_credit_card_balance_is_greater_than_order_price() {
        CreditCard creditCard = paymentRepository.getCreditCard();
        Order order = orderRepository.findById("1");
        assertThat(paymentRepository.validatePayment(order, creditCard)).isTrue();
    }

    @Test
    void update_balance_should_return_a_credit_card_with_balance_reduced_of_order_amount() {
        CreditCard creditCard = paymentRepository.getCreditCard();
        Order order = orderRepository.findById("1");
        if (paymentRepository.validatePayment(order, creditCard)) {
            creditCard.updateBalance(order.getPrice());
        }

        assertThat(creditCard.getBalance() == 83.0).isTrue();
    }

}
