package org.example.serialization;

import org.example.persons.customers.Customer;

/**
 * BankAccountOwnerXmlSerializationService
 */
import com.thoughtworks.xstream.XStream;

public class BankAccountOwnerXmlSerializationService implements Serialization{

	XStream xstream;
    BankAccountOwnerSerializationFactory bankAccountOwnerSerializationFactory = new BankAccountOwnerSerializationFactory();

	public BankAccountOwnerXmlSerializationService() {
		xstream = new XStream();
		xstream.allowTypesByWildcard(new String[]{"org.example.**"});
	}

	@Override
	public String serialization(Object serializationObject) {

        if (!(serializationObject instanceof Customer)) {
            throw new RuntimeException("serializationObject must be an instance of Customer");
        }

        BankAccountOwnerSerialization bankAccountOwnerSerialization = bankAccountOwnerSerializationFactory.createBankAccountOwnerSerialization((Customer) serializationObject);

		return xstream.toXML(bankAccountOwnerSerialization);	
	}

	@Override
	public Object deserialization(String serializedObject) {
		return xstream.fromXML(serializedObject);
	}
	
}
