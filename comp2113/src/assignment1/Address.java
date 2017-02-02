/*
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  01
 * Version:       1.0
 * File:          Address.java
 *
 * Simple class of common address info
 */

package Assignment1;

public class Address implements AddressInterface {
	protected String addressee;
	protected String street;
	protected String town; 
	protected String country; 
	protected String postalcode;
	
	public Address(String newAddressee, String newStreet, String newTown, 
			String newCountry, String newPostalcode) {
	// Constructor
		addressee = newAddressee;
		street = newStreet;
		town = newTown;
		country = newCountry;
		if (AddressInterface.checkPostalCode(newPostalcode) == false) {
			throw new IllegalArgumentException(newPostalcode);
		}
		postalcode = newPostalcode;
	}

	public Address(Address newAddr) {
	// Copy constructor
		if (newAddr == null) {
			//throw new IllegalArgumentException(newAddr);
			throw new IllegalArgumentException("Wrong format for postal code");
		}

		addressee = newAddr.addressee;
		street = newAddr.street;
		town = newAddr.town;
		country = newAddr.country;
		postalcode = newAddr.postalcode;
	}
	
	public String getAddressee() {
	// Return addressee name
		return addressee;
	}
	
	public String getStreet() {
	// Return street info
		return street;
	}
	
	public void setStreet(String newValue) {
	// Modify street info
		street = newValue;
	}
	
	public String getTown() {
	// Return town name
		return town;
	}
	
	public void setTown(String newValue) {
	// Modify town name
		town = newValue;
	}
	
	public String getCountry() {
	// Return country name
		return country;
	}
	
	public void setCountry(String newValue) {
	// Modify country name
		country = newValue;
	}
	
	public String getPostalCode() {
	// Return postal code
		return postalcode;
	}
	
	public void setPostalCode(String newValue) {
	// Modify postal code
		if (AddressInterface.checkPostalCode(newValue) == false) {
			throw new IllegalArgumentException(newValue);
		}
		postalcode = newValue;
	}

	public String toString() {
	// Return address details
		String output = addressee + "\n" + street + "\n" + town + "\n" + 
			country + "\n" + postalcode + "\n";
		return output;
	}
}
