package org.example.accounts.services;

import com.google.inject.Inject;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.validators.BankAccountValidator;
import org.example.logger.Logger;

public class BankAccountService {

	@Inject
	private Logger logger;
	@Inject
	private BankAccountValidator validator;

	public void deposit(BaseBankAccount account, double amount) {
		validator.validateDeposit(account, amount);

		logger.log(account.getUuid() + ": + " + amount);

		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
	}

	public void withdraw(BaseBankAccount account, double amount) {
		validator.validateWithdrawal(account, amount);

		logger.log(account.getUuid() + ": + " + amount);

		double newBalance = account.getBalance() - amount;
		account.setBalance(newBalance);
	}
}
