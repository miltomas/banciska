package org.example.cards;

import com.google.inject.Inject;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.services.BankAccountService;

/**
 * PaymentCardService
 */
public class PaymentCardService {

	@Inject
	private PaymentCardRepository paymentCardRepository;
	@Inject
	private BankAccountService bankAccountService;

	public void withdraw(PaymentCard card, double amount) throws Exception {
		BaseBankAccount account = paymentCardRepository.getBankAccountByCardNumber(
				card.getCardNumber());
		bankAccountService.withdraw(account, amount);
	}
}
