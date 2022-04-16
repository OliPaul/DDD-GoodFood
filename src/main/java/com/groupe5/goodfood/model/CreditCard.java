package com.groupe5.goodfood.model;

import com.groupe5.goodfood.use_case.InsufficientFundsException;
import com.groupe5.goodfood.use_case.InvalidCreditCardException;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Builder
@Getter
public class CreditCard {

    String cardNumber;
    LocalDate expirationDate;
    String holderName;
    int verificationCode;
    double balance;

    public boolean validCreditCard() {
        LocalDate now = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/yyyy")), new DateTimeFormatterBuilder()
                .appendPattern("MM/yyyy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter());
        return !expirationDate.isBefore(now);
    }

    public void updateBalance(double orderAmount) {
        balance -= orderAmount;
    }


    public boolean validatePayment(Order order) {
        return balance - order.getPrice() >= 0;
    }

    public void pay(Order order) throws InvalidCreditCardException, InsufficientFundsException {
        // Vérifier la validité de la carte de crédit
        if (!validCreditCard()) {
            throw new InvalidCreditCardException("Invalid Credit card");
        }
        // Valider le paiement
        if (!validatePayment(order)) {
            throw new InsufficientFundsException("Card balance insufficient");
        }
    }
}
