package org.example.accounts.factories;

import com.google.inject.Inject;
import org.example.accounts.BankAccount;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.SaveBankAccount;
import org.example.accounts.StudentBankAccount;
import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.persons.customers.Customer;

public class BankAccountFactory {

	@Inject
	private BankAccountNumberGenerator bankAccountNumberGenerator;

	public BankAccount createBankAccount(String uuid, Customer customer) {
		return new BankAccount(
				uuid, bankAccountNumberGenerator.generateRandomAccountNumber(),
				customer);
	}

	public SaveBankAccount createSaveAccount(String uuid, Customer customer,
			float interestRate) {
		return new SaveBankAccount(
				uuid, bankAccountNumberGenerator.generateRandomAccountNumber(),
				customer, interestRate);
	}

	public StudentBankAccount createStudentAccount(String uuid, Customer customer, String schoolName) {
		return new StudentBankAccount(
				uuid, bankAccountNumberGenerator.generateRandomAccountNumber(),
				customer, schoolName);
	}

	public BankAccountWithPaymentCards createBankAccountWithPaymentCards(String uuid, Customer customer) {
		return new BankAccountWithPaymentCards(
				uuid, bankAccountNumberGenerator.generateRandomAccountNumber(),
				customer, 5000);
	}
}
