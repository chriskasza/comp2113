/*
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  01
 * Version:       1.0
 * File:          ExtendedAddressInterface.java
 *
 * Interface that extends AddressInterface.  Adding to AddressInterface's
 * basic address info, this class holds the number of years the addressee
 * has lived at this address.
 */

package Assignment1;

public interface ExtendedAddressInterface extends AddressInterface {
	int getYears();
	// Return number of years at address 

	void setYears (int newValue);
	// Update number of years at address with newValue
}
