/*
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  01
 * Version:       1.0
 * File:          StringListTest.java
 *
 * Tester class for Address and ExtendedAddress classes
 */

package assignment2;

public class StringListTest {
	public static void main(String[] args) {
		EditorStringList stringlist1 = new EditorStringList();
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");

		stringlist1.insertFront("first");
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");
		
		stringlist1.insertAfter("second", "first");
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");

		stringlist1.insertBefore("zero", "first");
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");
		
		stringlist1.insertFront("negative");
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");
		
		stringlist1.remove("negative");
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");

		stringlist1.remove("first");
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");

		stringlist1.remove("second");
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");

		stringlist1.remove("zero");
		System.out.println(stringlist1.print() + "\n" + stringlist1.revPrint() + "\n");

		//stringlist1.remove("zero");
	}
}
