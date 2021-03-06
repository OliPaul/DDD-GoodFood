package com.groupe5.goodfood.use_case;

import com.groupe5.goodfood.model.CreditCard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class FakeCreditCard implements PaymentRepository {

    CreditCard creditCard;

    FakeCreditCard() {
        creditCard = CreditCard
                .builder()
                .cardNumber("4532-8297-3531-1137")
                .holderName("A user")
                .expirationDate(LocalDate.parse("08/2028", new DateTimeFormatterBuilder()
                        .appendPattern("MM/yyyy")
                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                        .toFormatter()))
                .verificationCode(100)
                .balance(100)
                .build();
    }

    @Override
    public CreditCard getCreditCard() {
        return creditCard;
    }

    @Override
    public CreditCard getExpiredCreditCard() {

        return CreditCard
                .builder()
                .cardNumber("4544-8297-3531-2678")
                .holderName("A user")
                .expirationDate(LocalDate.parse("08/2020", new DateTimeFormatterBuilder()
                        .appendPattern("MM/yyyy")
                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                        .toFormatter()))
                .verificationCode(100)
                .balance(100)
                .build();
    }


}
