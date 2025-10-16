package org.example.cards;

import java.security.SecureRandom;

public class PaymentCardNumberGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();

    public String generateCardNumber() {
        StringBuilder sb = new StringBuilder(19); // 16 digits + 3 hyphens
        for (int block = 0; block < 4; block++) {
            for (int i = 0; i < 4; i++) {
                sb.append(RANDOM.nextInt(10)); // 0..9
            }
            if (block < 3) sb.append('-');
        }

        return sb.toString();
    }

}
