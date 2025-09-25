package org.example.persons.customers.factories;

import org.example.persons.customers.Customer;

public class CustomerFactory {

    public Customer createCustomer(String uuid, String firstName, String lastName) {
        return new Customer(uuid, firstName, lastName);
    }

}
