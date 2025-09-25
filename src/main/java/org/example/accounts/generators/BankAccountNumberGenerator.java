package org.example.accounts.generators;

import java.util.Random;

public class BankAccountNumberGenerator {

    private final byte GENERATED_ACCOUNT_NUMBER_LENGTH = 10;

    public String generateRandomAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        // Generate 10 random digits (0–9)
        for (int i = 0; i < GENERATED_ACCOUNT_NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10); // 0-9
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }


}
