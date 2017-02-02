/*
 * Author;        Chris Kasza
 * Student #;     100133723
 * Course;        COMP 2113 N1
 * Assignment #;  01
 * Version;       1.0
 * File;          InterfaceAddress.java
 *
 * Interface for a class of common address info including
 * addressee name
 * street
 * town
 * country
 * postal code
 */

package Assignment1;

public interface AddressInterface {
   public static boolean checkPostalCode(String pCode) {
	// Returns true if pCode is proper postal code format
      final String REGEX = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z]"
            + "[0-9]$";
      return pCode.toUpperCase().matches(REGEX);
   }

	String getAddressee();
	// Returns addressee name of this Address
	
	String getStreet();
	// Returns street of this Address
	
	void setStreet(String newValue);
	// Updates street of this Address to newValue
	
	String getTown();
	// Returns town of this Address
	
	void setTown(String newValue);
	// Updates town of this Address to newValue
	
	String getCountry();
	// Returns country of this Address
	
	void setCountry(String newValue);
	// Updates country of this Address to newValue
	
	String getPostalCode();
	// Returns postal code of this Address
	
	void setPostalCode(String newValue);
	// Precondition; new postal code, newValue, must be proper format	
	//
	// Updates postal code of this Address to newValue

	String toString();
	// Returns complete address in standard format
}
