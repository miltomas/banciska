package org.example.people;

/**
 * BankAccountOwner
 */
public class BankAccountOwner {
	public BankAccountOwner(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
