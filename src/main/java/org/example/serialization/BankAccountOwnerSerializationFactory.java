package org.example.serialization;

import org.example.persons.customers.Customer;

public class BankAccountOwnerSerializationFactory {

    public BankAccountOwnerSerialization createBankAccountOwnerSerialization(Customer bankAccountOwner) {
        BankAccountOwnerSerialization  bankAccountOwnerSerialization = new BankAccountOwnerSerialization();

        bankAccountOwnerSerialization.uuid = bankAccountOwner.getUuid();
        bankAccountOwnerSerialization.firstName = bankAccountOwner.getFirstName();
        bankAccountOwnerSerialization.lastName = bankAccountOwner.getLastName();

        return bankAccountOwnerSerialization;
    }

}
