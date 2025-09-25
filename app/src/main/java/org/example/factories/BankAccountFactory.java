package org.example.factories;

import org.example.bankAccounts.SavingBankAccount;
import org.example.generators.BankAccountNumberGenerator;
import org.example.people.BankAccountOwner;

/**
 * BankAccountFactory
 */
public class BankAccountFactory {
	private final BankAccountNumberGenerator generator = new BankAccountNumberGenerator();

	public SavingBankAccount createSavingBankAccount(String uuid, BankAccountOwner owner) {
		return new SavingBankAccount(uuid, generator.generateNumber(), 0);
	}
}
