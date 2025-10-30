package org.example.accounts;

/**
 * SaveBankAccountService
 */
public class SaveBankAccountService {

	public void interestBalance(SaveBankAccount account) {
		float interestRate = account.getInterestRate();
		double balance = account.getBalance();

		account.setBalance(balance * (1 + interestRate));
	}

}
