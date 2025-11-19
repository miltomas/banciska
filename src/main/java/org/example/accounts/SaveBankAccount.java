package org.example.accounts;

import java.time.Instant;
import org.example.persons.customers.Customer;

public class SaveBankAccount extends BaseBankAccount {

	private final float interestRate;

	private Instant lastInterestInstant;

	private Instant nextInterestInstant;

	public SaveBankAccount(String uuid, String bankAccountNumber,
			Customer customer, float interestRate,
			Instant lastInterestInstant,
			Instant nextInterestInstant) {

		super(uuid, bankAccountNumber, customer, 0);

		this.interestRate = interestRate;
		this.lastInterestInstant = lastInterestInstant;
		this.nextInterestInstant = nextInterestInstant;
	}

	public SaveBankAccount(String uuid, String bankAccountNumber,
			Customer customer) {

		this(uuid, bankAccountNumber, customer, 0, null, null);
	}

	public float getInterestRate() {
		return interestRate;
	}

	public Instant getLastInterestInstant() {
		return lastInterestInstant;
	}

	public Instant getNextInterestInstant() {
		return nextInterestInstant;
	}

	public void setLastInterestInstant(Instant lastInterestInstant) {
		this.lastInterestInstant = lastInterestInstant;
	}

	public void setNextInterestInstant(Instant nextInterestInstant) {
		this.nextInterestInstant = nextInterestInstant;
	}

}
