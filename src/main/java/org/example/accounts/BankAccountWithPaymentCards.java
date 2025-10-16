package org.example.accounts;

import org.example.cards.PaymentCard;
import org.example.persons.customers.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountWithPaymentCards extends BaseBankAccount {

    protected final List<PaymentCard> paymentCards;
    protected final Map<String, PaymentCard> paymentCardsMap;

    public BankAccountWithPaymentCards(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid, bankAccountNumber, customer, balance);

        this.paymentCards = new ArrayList<>();
        this.paymentCardsMap = new HashMap<>();
    }

    public void addPaymentCard(PaymentCard paymentCard) {
        this.paymentCards.add(paymentCard);
        this.paymentCardsMap.put(paymentCard.getCardNumber(), paymentCard);
    }
}
