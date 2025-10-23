package org.example.cards;

import java.util.UUID;
import org.example.accounts.BankAccountWithPaymentCards;

import com.google.inject.Inject;

public class PaymentCardFactory {

	@Inject
	private PaymentCardNumberGenerator paymentCardNumberGenerator;
	@Inject
	private PaymentCardCvvGenerator paymentCardCvvGenerator;
	@Inject
	private PaymentCardPinGenerator paymentCardPinGenerator;
	@Inject
	private PaymentCardExpirationCalculator paymentCardExpirationCalculator;
	@Inject
	private PaymentCardRepository paymentCardRepository;

	public PaymentCard create(BankAccountWithPaymentCards account) {

		String uuid = UUID.randomUUID().toString();
		String cardNumber = this.paymentCardNumberGenerator.generateCardNumber();
		String cvv = this.paymentCardCvvGenerator.generateCvv();
		// !!!
		String pin = this.paymentCardPinGenerator.generatePin();
		String expireMonth = this.paymentCardExpirationCalculator.calculateMonthExpire();
		String expireYear = this.paymentCardExpirationCalculator.calculateYearExpire();

		PaymentCard card = new PaymentCard(uuid, cardNumber, cvv, pin,
				expireMonth, expireYear);
		account.addPaymentCard(card);
		paymentCardRepository.linkCardToAccount(cardNumber, account);

		return card;
	}
}
