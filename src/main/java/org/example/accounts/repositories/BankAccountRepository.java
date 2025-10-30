package org.example.accounts.repositories;

import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.example.accounts.BaseBankAccount;

/**
 * BankAccountRepository
 */
@Singleton
public class BankAccountRepository {

	private Collection<BaseBankAccount> bankAccounts = new ArrayList<BaseBankAccount>();

	public Collection<BaseBankAccount> getBankAccounts() {
		return Collections.unmodifiableCollection(bankAccounts);
	}

	public void addBankAccount(BaseBankAccount account) {
		bankAccounts.add(account);
	}
}
