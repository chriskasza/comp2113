/*
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  01
 * Version:       1.0
 * File:          ExtendedAddress.java
 *
 * Extends Address and provides number of years residing at address.
 */

package Assignment1;

public class ExtendedAddress extends Address implements 
		ExtendedAddressInterface {
	protected int years;
	
	// Constructor
	public ExtendedAddress(String newAddressee, String newStreet, 
			String newTown, String newCountry, String newPostalcode, 
			int newYears) {
		super(newAddressee, newStreet, newTown, newCountry, newPostalcode);
		years = newYears;
	}

	// Copy constructor
   public ExtendedAddress(ExtendedAddress newAddr) {
		super(newAddr.addressee, newAddr.street, newAddr.town, newAddr.country, 
				newAddr.postalcode);

      if (newAddr == null) {
         throw new IllegalArgumentException("Address is null");
      }

		years = newAddr.years;
   }

	// Return number of years at address
	public int getYears() {
		return years;
	}

	// Modify number of years at address
	public void setYears (int newValue) {
		years = newValue;
	}
}
