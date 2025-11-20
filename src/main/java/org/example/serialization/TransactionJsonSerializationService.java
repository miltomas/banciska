package org.example.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.google.inject.Inject;
import java.time.Instant;
import org.example.transactions.Transaction;

public class TransactionJsonSerializationService implements Serialization {

	Gson gson = new GsonBuilder()
			.registerTypeAdapter(
					Instant.class,
					(JsonSerializer<Instant>) (src, typeOfSrc, context) -> new JsonPrimitive(src.toString()))
			.registerTypeAdapter(
					Instant.class,
					(JsonDeserializer<Instant>) (json, typeOfT, context) -> Instant.parse(json.getAsString()))
			.create();

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
