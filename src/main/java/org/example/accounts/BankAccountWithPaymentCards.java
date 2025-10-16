package org.example.accounts;

import java.util.ArrayList;
import java.util.List;

import org.example.cards.PaymentCard;
import org.example.persons.customers.Customer;

public class BankAccountWithPaymentCards extends BaseBankAccount {

    protected final List<PaymentCard> paymentCards;

    public BankAccountWithPaymentCards(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid, bankAccountNumber, customer, balance);

        this.paymentCards = new ArrayList<>();
    }

    public void addPaymentCard(PaymentCard paymentCard) {
        this.paymentCards.add(paymentCard);
    }
}
