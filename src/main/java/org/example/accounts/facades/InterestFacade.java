package org.example.accounts.facades;

import com.google.inject.Inject;
import java.time.Instant;
import java.util.Collection;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveBankAccount;
import org.example.accounts.repositories.BankAccountRepository;
import org.example.accounts.services.SaveBankAccountService;
import org.example.logger.Logger;

/**
 * InterestFacade
 */
public class InterestFacade {

	@Inject
	SaveBankAccountService saveBankAccountService;
	@Inject
	BankAccountRepository bankAccountRepository;
	@Inject
	Logger logger;

	// in seconds
	public static final int INTEREST_INTERVAL = 5;

	public void interestAllSaveBankAccounts() {
		Collection<BaseBankAccount> bankAccounts = bankAccountRepository.getBankAccounts();

		for (BaseBankAccount account : bankAccounts) {
			if (account instanceof SaveBankAccount savingsAccount) {
				checkValidityInterestOrSkip(savingsAccount);
			}
		}
	}

	private void checkValidityInterestOrSkip(SaveBankAccount account) {
		if (account.getNextInterestInstant().isAfter(Instant.now())) {
			return;
		}

		logger.log("[" + account.getUuid() + "]" + " " + account.getBalance());
		saveBankAccountService.interestBalance(account);
		logger.log("[" + account.getUuid() + "]" + " " + account.getBalance());

		account.setLastInterestInstant(Instant.now());
		account.setNextInterestInstant(
				Instant.now().plusSeconds(INTEREST_INTERVAL));
	}
}
