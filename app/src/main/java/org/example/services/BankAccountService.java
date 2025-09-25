package org.example.services;

import org.example.bankAccounts.BaseBankAccount;

/**
 * BankAccountService
 */
public class BankAccountService {
	public void deposit(BaseBankAccount account, double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException(
					"Deposit amount must be positive");
		}

		System.out.println(account.getUuid() + ": + " + amount);

		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
	}

	public void withdraw(BaseBankAccount account, double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException(
					"Withdraw amount must be positive");
		}

		if (account.getBalance() - amount < 0) {
			throw new IllegalArgumentException("Ajaj no money");
		}

		System.out.println(account.getUuid() + ": - " + amount);

		double newBalance = account.getBalance() - amount;
		account.setBalance(newBalance);
	}
}
