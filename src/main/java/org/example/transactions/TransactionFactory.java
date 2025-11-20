package org.example.transactions;

import java.time.Instant;
import org.example.accounts.BaseBankAccount;

/**
 * TransactionFactory
 */
public class TransactionFactory {

	public Transaction
	createTransaction(Instant instant, BaseBankAccount account,
					  Transaction.TransactionType transactionType, double amount) {
		return new Transaction(instant, account, transactionType, amount);
	}
}
