package org.example.accounts;

import org.example.persons.customers.Customer;

public class SaveBankAccount extends BaseBankAccount {

    private final float interestRate;

    public SaveBankAccount(String uuid, String bankAccountNumber, Customer customer, float interestRate) {
        super(uuid, bankAccountNumber, customer, 0);

        this.interestRate = interestRate;
    }

    public SaveBankAccount(String uuid, String bankAccountNumber, Customer customer) {
        this(uuid, bankAccountNumber, customer, 0);
    }

    public float getInterestRate() {
        return interestRate;
    }
}
