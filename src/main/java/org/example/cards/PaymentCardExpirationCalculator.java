package org.example.cards;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PaymentCardExpirationCalculator {

    private static final byte DEFAULT_EXPIRATION_YEAR_LENGTH = 5;

    private static final DateTimeFormatter MONTH_FMT = DateTimeFormatter.ofPattern("MM");
    private static final DateTimeFormatter YEAR_FMT_SHORT = DateTimeFormatter.ofPattern("yy");

    public String calculateMonthExpire() {
        LocalDate today = LocalDate.now();

        return today.format(MONTH_FMT);
    }

    public String calculateYearExpire() {
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusYears(DEFAULT_EXPIRATION_YEAR_LENGTH);

        return future.format(YEAR_FMT_SHORT);
    }

}
