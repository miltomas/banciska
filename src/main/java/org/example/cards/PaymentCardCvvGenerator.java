package org.example.cards;

import java.security.SecureRandom;

public class PaymentCardCvvGenerator {

    private static final byte DEFAULT_CVV_LENGTH = 3;

    private static final SecureRandom RANDOM = new SecureRandom();

    public String generateCvv() {

        int max = (int) Math.pow(10, DEFAULT_CVV_LENGTH);
        int value = RANDOM.nextInt(max); // 0 .. max-1
        return String.format("%0" + DEFAULT_CVV_LENGTH + "d", value);
    }

}
