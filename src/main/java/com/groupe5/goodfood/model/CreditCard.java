package com.groupe5.goodfood.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.datetime.DateFormatter;

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
}
