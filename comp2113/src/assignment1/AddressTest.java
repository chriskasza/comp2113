/*
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  01
 * Version:       1.0
 * File:          AddressTest.java
 *
 * Tester class for Address and ExtendedAddress classes
 */

package Assignment1.*;

public class AddressTest {
	public static void main(String[] args) {
		try {
			AddressInterface address;
			address = new Address("Billy Joe Bob", "123 Sycamore Ln.", 
					"Centreville", "Canada", "A1A1A1");
			System.out.println("Address Test:");
			System.out.println(address);
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + e.getMessage());
		}

		try {
			ExtendedAddressInterface extAddr;
			extAddr = new ExtendedAddress("Jordy", "Deck 3", "Enterprise D", 
					"Federation", "B0p 1H0", 3);
			System.out.println("\nExtended Test:");
			System.out.println(extAddr);
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + e.getMessage());
		}

		try {
			AddressInterface failAddr;
			failAddr= new Address("Cory", "123 Sycamore Ln.", "Centreville",
					"Canada", "D1A1A1");
			System.out.println("Address Test:");
			System.out.println(failAddr);
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + e.getMessage());
		}
	}
}
