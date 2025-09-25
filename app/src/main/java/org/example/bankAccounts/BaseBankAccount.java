package org.example.bankAccounts;

/**
 * BaseBankAccount
 */
public abstract class BaseBankAccount {
	public BaseBankAccount(String uuid, String number, double balance) {
		this.uuid = uuid;
		this.number = number;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUuid() {
		return uuid;
	}

	public String getNumber() {
		return number;
	}

	public double balance;
	private String uuid;
	private String number;
}
