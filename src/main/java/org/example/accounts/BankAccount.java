package org.example.accounts;

import org.example.persons.customers.Customer;

public class BankAccount extends BankAccountWithPaymentCards {

    public BankAccount(String uuid, String bankAccountNumber, Customer customer) {
        super(uuid, bankAccountNumber, customer, 0);
    }

}
