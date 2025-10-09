package org.example.serialization;

/**
 * BankAccountOwnerXmlSerializationService
 */
import com.thoughtworks.xstream.XStream;

public class BankAccountOwnerXmlSerializationService implements Serialization{

	XStream xstream;

	public BankAccountOwnerXmlSerializationService() {
		xstream = new XStream();
		xstream.allowTypesByWildcard(new String[]{"org.example.**"});
	}

	@Override
	public String serialization(Object serializationObject) {
		return xstream.toXML(serializationObject);	

	}

	@Override
	public Object deserialization(String serializedObject) {
		return xstream.fromXML(serializedObject);
	}
	
}
