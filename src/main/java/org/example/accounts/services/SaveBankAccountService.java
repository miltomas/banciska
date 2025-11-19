package org.example.accounts.services;

import com.google.inject.Inject;
import org.example.accounts.SaveBankAccount;

/**
 * SaveBankAccountService
 */
public class SaveBankAccountService {

	@Inject
	BankAccountService bankAccountService;

	public void interestBalance(SaveBankAccount account) {
		bankAccountService.deposit(account, calculateInterest(account));
	}

	private double calculateInterest(SaveBankAccount account) {
		return account.getBalance() * account.getInterestRate() / 100;
	}
}
