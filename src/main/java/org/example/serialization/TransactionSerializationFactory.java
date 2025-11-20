package org.example.serialization;

import org.example.transactions.Transaction;

/**
 * TransactionSerializationFactory
 */
public class TransactionSerializationFactory {

	public TransactionSerialization createTransactionSerialization(Transaction transaction) {

		TransactionSerialization transactionSerialization = new TransactionSerialization();

		transactionSerialization.instant = transaction.getInstant();
		transactionSerialization.account = transaction.getAccount();
		transactionSerialization.transactionType = transaction.getTransactionType();
		transactionSerialization.amount = transaction.getAmount();

		return transactionSerialization;
	}
}
