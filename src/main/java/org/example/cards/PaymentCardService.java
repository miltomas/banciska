package org.example.cards;

import org.example.accounts.BaseBankAccount;
import org.example.accounts.services.BankAccountService;

/**
 * PaymentCardService
 */
public class PaymentCardService {

	private PaymentCardRepository paymentCardRepository;	
	private BankAccountService bankAccountService;

	public PaymentCardService(PaymentCardRepository paymentCardRepository, BankAccountService bankAccountService) {
		this.paymentCardRepository = paymentCardRepository;
		this.bankAccountService = bankAccountService;
	}

	public void withdraw(PaymentCard card, double amount) {
		BaseBankAccount account = paymentCardRepository.getBankAccountByCardNumber(card.getCardNumber());
		bankAccountService.withdraw(account, amount);	
	}
}
