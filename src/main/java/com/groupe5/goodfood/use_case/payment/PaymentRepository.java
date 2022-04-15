package com.groupe5.goodfood.use_case.payment;

import com.groupe5.goodfood.model.CreditCard;
import com.groupe5.goodfood.model.Order;

public interface PaymentRepository {
    CreditCard getCreditCard();
}
