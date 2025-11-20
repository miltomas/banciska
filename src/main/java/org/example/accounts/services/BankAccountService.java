package org.example.accounts.services;

import com.google.inject.Inject;
import java.time.Instant;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.validators.BankAccountValidator;
import org.example.logger.Logger;
import org.example.transactions.Transaction;
import org.example.transactions.Transaction.TransactionType;
import org.example.transactions.TransactionFactory;
import org.example.transactions.TransactionRepository;

public class BankAccountService {

	@Inject private Logger logger;
	@Inject private BankAccountValidator validator;
	@Inject private TransactionRepository transactionRepository;
	@Inject private TransactionFactory transactionFactory;

	public void deposit(BaseBankAccount account, double amount) {
		validator.validateDeposit(account, amount);

		logger.log(account.getUuid() + ": + " + amount);

		Transaction transaction = transactionFactory.createTransaction(
			Instant.now(), account, TransactionType.DEPOSIT, amount);

		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);

		transactionRepository.registerTransaction(transaction);
	}

	public void withdraw(BaseBankAccount account, double amount) {
		validator.validateWithdrawal(account, amount);

		Transaction transaction = transactionFactory.createTransaction(
			Instant.now(), account, TransactionType.WITHDRAWAL, amount);

		logger.log(account.getUuid() + ": - " + amount);

		double newBalance = account.getBalance() - amount;
		account.setBalance(newBalance);

		transactionRepository.registerTransaction(transaction);
	}
}
