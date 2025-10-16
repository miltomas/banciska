package org.example.cards;

import java.util.HashMap;
import java.util.Map;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;

/**
 * PaymentCardRepository
 */
public class PaymentCardRepository {

	private Map<String, BankAccountWithPaymentCards> bankAccountMap = new HashMap<>();

	public void linkCardToAccount(String cardNumber,
			BankAccountWithPaymentCards account) {
		bankAccountMap.put(cardNumber, account);
	}

	public BaseBankAccount getBankAccountByCardNumber(String cardNumber) throws Exception {
		BaseBankAccount account = bankAccountMap.get(cardNumber);

		if (account == null)
			throw new Exception("Neexistuje.");
		return account;
	}
}
