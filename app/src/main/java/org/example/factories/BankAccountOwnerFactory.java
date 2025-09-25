package org.example.factories;

import org.example.people.BankAccountOwner;

/**
 * BankAccountOwnerFactory
 */
public class BankAccountOwnerFactory {
	public BankAccountOwner createBankAccountOwner(String firstName, String lastName) {
		return new BankAccountOwner(firstName, lastName);
	}
}
