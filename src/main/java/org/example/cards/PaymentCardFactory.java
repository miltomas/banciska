package org.example.cards;

import java.util.UUID;

public class PaymentCardFactory {

    private final PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    private final PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();
    private final PaymentCardPinGenerator  paymentCardPinGenerator = new PaymentCardPinGenerator();
    private final PaymentCardExpirationCalculator paymentCardExpirationCalculator = new PaymentCardExpirationCalculator();

    public PaymentCard create() {

        String uuid = UUID.randomUUID().toString();
        String cardNUmber = this.paymentCardNumberGenerator.generateCardNumber();
        String cvv = this.paymentCardCvvGenerator.generateCvv();
        // !!!
        String pin = this.paymentCardPinGenerator.generatePin();
        String expireMonth = this.paymentCardExpirationCalculator.calculateMonthExpire();
        String expireYear = this.paymentCardExpirationCalculator.calculateYearExpire();

        return new PaymentCard(uuid, cardNUmber, cvv, pin, expireMonth, expireYear);
    }
}
