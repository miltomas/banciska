package org.example.transactions;

import java.time.Instant;
import org.example.accounts.BaseBankAccount;

/**
 * Transaction
 */
public class Transaction {

	private Instant instant;
	private BaseBankAccount account;
	private TransactionType transactionType;
	private double amount;

	public Transaction() {}
	public Transaction(Instant instant, BaseBankAccount account, TransactionType transactionType, double amount) {
		this.instant = instant;
		this.account = account;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	
	public enum TransactionType { WITHDRAWAL, DEPOSIT }

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public BaseBankAccount getAccount() {
		return account;
	}

	public void setAccount(BaseBankAccount account) {
		this.account = account;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
