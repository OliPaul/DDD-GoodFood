package com.groupe5.goodfood.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
public class CreditCard {

    String cardNumber;
    LocalDate expirationDate;
    String holderName;
    int verificationCode;
    double balance;


}
