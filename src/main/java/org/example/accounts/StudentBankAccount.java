package org.example.accounts;

import org.example.persons.customers.Customer;

public class StudentBankAccount extends BaseBankAccount {

    private final String schoolName;

    public StudentBankAccount(String uuid, String bankAccountNumber, Customer customer, String schoolName) {
        super(uuid, bankAccountNumber, customer, 0);

        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
