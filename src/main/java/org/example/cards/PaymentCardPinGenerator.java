package org.example.cards;

import java.security.SecureRandom;

public class PaymentCardPinGenerator {

    private static final byte DEFAULT_PIN_LENGTH = 4;

    private static final SecureRandom RANDOM = new SecureRandom();

    public String generatePin() {
        int max = (int) Math.pow(10, DEFAULT_PIN_LENGTH);
        int value = RANDOM.nextInt(max);
        return String.format("%0" + DEFAULT_PIN_LENGTH + "d", value);
    }

}
