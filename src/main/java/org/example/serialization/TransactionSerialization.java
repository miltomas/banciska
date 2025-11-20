package org.example.serialization;

import java.time.Instant;
import org.example.accounts.BaseBankAccount;
import org.example.transactions.Transaction.TransactionType;

/**
 * TransactionSerialization
 */
public class TransactionSerialization {

	public Instant instant;
	public BaseBankAccount account;
	public TransactionType transactionType;
	public double amount;
}
