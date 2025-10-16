package org.example.cards;

import java.util.UUID;

import org.example.accounts.BankAccountWithPaymentCards;

public class PaymentCardFactory {

    private final PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    private final PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();
    private final PaymentCardPinGenerator  paymentCardPinGenerator = new PaymentCardPinGenerator();
    private final PaymentCardExpirationCalculator paymentCardExpirationCalculator = new PaymentCardExpirationCalculator();
	private final PaymentCardRepository paymentCardRepository;

	public PaymentCardFactory(PaymentCardRepository paymentCardRepository) {
		this.paymentCardRepository = paymentCardRepository;
	}

    public PaymentCard create(BankAccountWithPaymentCards account) {

        String uuid = UUID.randomUUID().toString();
        String cardNumber = this.paymentCardNumberGenerator.generateCardNumber();
        String cvv = this.paymentCardCvvGenerator.generateCvv();
        // !!!
        String pin = this.paymentCardPinGenerator.generatePin();
        String expireMonth = this.paymentCardExpirationCalculator.calculateMonthExpire();
        String expireYear = this.paymentCardExpirationCalculator.calculateYearExpire();
	

		PaymentCard card = new PaymentCard(uuid, cardNumber, cvv, pin, expireMonth, expireYear);
		account.addPaymentCard(card);
		paymentCardRepository.linkCardToAccount(cardNumber, account);

        return card;
    }
}
