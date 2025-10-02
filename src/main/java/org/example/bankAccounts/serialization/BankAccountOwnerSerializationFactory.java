package org.example.bankAccounts.serialization;

import org.example.people.BankAccountOwner;

public class BankAccountOwnerSerializationFactory {

    public BankAccountOwnerSerialization createBankAccountOwnerSerialization(BankAccountOwner bankAccountOwner) {
        BankAccountOwnerSerialization  bankAccountOwnerSerialization = new BankAccountOwnerSerialization();

        bankAccountOwnerSerialization.uuid = bankAccountOwner.getUuid();
        bankAccountOwnerSerialization.firstName = bankAccountOwner.getFirstName();
        bankAccountOwnerSerialization.lastName = bankAccountOwner.getLastName();

        return bankAccountOwnerSerialization;
    }

}
