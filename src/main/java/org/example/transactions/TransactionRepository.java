package org.example.transactions;

import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.example.accounts.BaseBankAccount;

/**
 * TransactionRepository
 */
@Singleton
public class TransactionRepository {

	private Map<String, Collection<Transaction>> bankAccountMap = new HashMap<>();

	public void registerTransaction(Transaction transaction) {
		String uuid = transaction.getAccount().getUuid();

		if (bankAccountMap.get(uuid) == null) {
			bankAccountMap.put(uuid, new ArrayList<Transaction>());
		}

		bankAccountMap.get(uuid).add(transaction);
	}

	public Map<String, Collection<Transaction>> getTransactions() {
		return bankAccountMap;
	}

	public Collection<Transaction> getTransactionsFromBankAccount(BaseBankAccount account) {
		return bankAccountMap.get(account.getUuid());
	}
}
