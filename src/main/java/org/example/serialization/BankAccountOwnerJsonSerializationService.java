package org.example.serialization;

import com.google.gson.Gson;
import org.example.persons.customers.Customer;

public class BankAccountOwnerJsonSerializationService implements Serialization {

    Gson gson = new Gson();
    BankAccountOwnerSerializationFactory bankAccountOwnerSerializationFactory = new BankAccountOwnerSerializationFactory();

    @Override
    public String serialization(Object bankAccountOwner) {

        if (!(bankAccountOwner instanceof Customer)) {
            throw new RuntimeException("BankAccountOwner must be an instance of BankAccountOwner");
        }

        BankAccountOwnerSerialization bankAccountOwnerSerialization = bankAccountOwnerSerializationFactory.createBankAccountOwnerSerialization((Customer) bankAccountOwner);

        /*
          StringBuilder sb = new StringBuilder();
          sb.append("{");
          sb.append("\"uuid\":\"" + bankAccountOwnerSerialization.uuid + "\",");
          sb.append("\"firstName\":\"" + bankAccountOwnerSerialization.firstName + "\",");
          sb.append("\"lastName\":\"" + bankAccountOwnerSerialization.lastName + "\"");
          sb.append("}");
        */

        return gson.toJson(bankAccountOwnerSerialization);
    }

    @Override
    public Object deserialization(String serializedObject) {
        return gson.fromJson("",  Customer.class);
    }
}
