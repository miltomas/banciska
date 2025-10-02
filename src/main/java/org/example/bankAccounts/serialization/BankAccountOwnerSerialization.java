package org.example.bankAccounts.serialization;

import com.google.gson.annotations.SerializedName;

public class BankAccountOwnerSerialization {

    public String uuid;

    @SerializedName("jmeno")
    public String firstName;

    public String lastName;
}
