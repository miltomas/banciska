package org.example.transactions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.accounts.BaseBankAccount;

/**
 * TransactionRepository
 */
public class TransactionRepository {

	private Map<String, Collection<Transaction>> bankAccountMap =
		new HashMap<>();

	public void registerTransaction(Transaction transaction) {
		String uuid = transaction.getAccount().getUuid();

		if (bankAccountMap.get(uuid) == null) {
			bankAccountMap.put(uuid, new ArrayList<Transaction>());
		}

		bankAccountMap.get(uuid).add(transaction);
	}

	public Collection<Transaction>
	getTransactionsFromBankAccount(BaseBankAccount account) {
		return bankAccountMap.get(account.getUuid());
	}
}
