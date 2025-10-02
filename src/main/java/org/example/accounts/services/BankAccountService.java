package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;
import org.example.logger.ConsoleLogger;
import org.example.logger.Logger;
import org.example.accounts.validators.BankAccountValidator;

public class BankAccountService {

    private final Logger logger = new ConsoleLogger();
	private final BankAccountValidator validator = new BankAccountValidator();

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
