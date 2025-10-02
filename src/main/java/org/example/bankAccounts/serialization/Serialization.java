package org.example.bankAccounts.serialization;

public interface Serialization {

    public String serialization(Object serializationObject);

    public Object deserialization(String serializedObject);

}
