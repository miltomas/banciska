package org.example.accounts.validators;

import org.example.accounts.BaseBankAccount;

public class BankAccountValidator {

	public void validateDeposit(BaseBankAccount account, double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException(
				"Deposit amount must be positive.");
		}

		if (amount > 10000) {
			System.err.println("Amount to be deposited is greater than 10000.");
		}
	}

	public void validateWithdrawal(BaseBankAccount account, double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException(
				"Withdrawal amount must be positive.");
		}
		if (account.getBalance() < amount) {
			throw new IllegalStateException("Insufficient funds.");
		}
	}
}
