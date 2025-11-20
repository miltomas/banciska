package org.example.serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.example.transactions.Transaction;

public class TransactionJsonSerializationService implements Serialization {

	@Inject
	Gson gson;
	@Inject
	TransactionSerializationFactory transactionSerializationFactory;

	@Override
	public String serialization(Object transaction) {

		if (!(transaction instanceof Transaction)) {
			throw new RuntimeException(
					"transaction must be an instance of Transaction");
		}

		TransactionSerialization transactionSerialization = transactionSerializationFactory
				.createTransactionSerialization(
						(Transaction) transaction);

		return gson.toJson(transactionSerialization);
	}

	@Override
	public Object deserialization(String serializedObject) {
		return gson.fromJson("", Transaction.class);
	}
}
