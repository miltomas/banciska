package org.example.accounts.facades;

import com.google.inject.Inject;
import java.util.Collection;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveBankAccount;
import org.example.accounts.repositories.BankAccountRepository;
import org.example.accounts.services.SaveBankAccountService;

/**
 * InterestFacade
 */
public class InterestFacade {

	@Inject
	SaveBankAccountService saveBankAccountService;
	@Inject
	BankAccountRepository bankAccountRepository;

	public void interestAllSaveBankAccounts() {
		Collection<BaseBankAccount> bankAccounts = bankAccountRepository.getBankAccounts();

		for (BaseBankAccount account : bankAccounts) {
			if (account instanceof SaveBankAccount savingsAccount) {
				checkValidityInterestOrSkip(savingsAccount);
			}
		}
	}

	private void checkValidityInterestOrSkip(SaveBankAccount account) {
		saveBankAccountService.interestBalance(account);
	}
}
