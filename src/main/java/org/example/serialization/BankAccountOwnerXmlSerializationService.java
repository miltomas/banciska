package org.example.serialization;

import com.google.inject.Inject;
/**
 * BankAccountOwnerXmlSerializationService
 */
import com.thoughtworks.xstream.XStream;
import org.example.persons.customers.Customer;

public class BankAccountOwnerXmlSerializationService implements Serialization {

	@Inject XStream xstream;
	@Inject
	BankAccountOwnerSerializationFactory bankAccountOwnerSerializationFactory;

	@Override
	public String serialization(Object serializationObject) {

		if (!(serializationObject instanceof Customer)) {
			throw new RuntimeException(
				"serializationObject must be an instance of Customer");
		}

		BankAccountOwnerSerialization bankAccountOwnerSerialization =
			bankAccountOwnerSerializationFactory
				.createBankAccountOwnerSerialization(
					(Customer)serializationObject);

		return xstream.toXML(bankAccountOwnerSerialization);
	}

	@Override
	public Object deserialization(String serializedObject) {
		return xstream.fromXML(serializedObject);
	}
	@Inject
	public void initializeXStream() {
		xstream.allowTypesByWildcard(new String[] {"org.example.**"});
	}
}
