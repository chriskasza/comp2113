/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 03
 * Version:      1.0
 * File:         UnsortedListDriver.java
 *
 * Driver for the AnotherUnsortedList class
 * 
 */
package Assignment4;

import ch04.genericLists.*;


public class ListDriver {

	public static void main(String[] args) {
		NewList unsortedList = new UnsortedList();
		NewList anotherList = new AnotherUnsortedList();		
		String[] elements = new String[]{"First", "Second", "Third", "Fourth", "Fifth"};
		
		for(String s : elements) {
			unsortedList.insert(new ListString(s));
			anotherList.insert(new ListString(s));
		}
		
		System.out.println("Unsorted List");
		System.out.println("Forwards Order: " + ListDriver.print(unsortedList.elements()));
		System.out.println("Reverse Order: " + ListDriver.printReverse(unsortedList.elements()) + "\n");

		System.out.println("Another Unsorted List");
		System.out.println("Forwards Order: " + ListDriver.print(anotherList.elements()));
		System.out.println("Reverse Order: " + ListDriver.printReverse(anotherList.elements()) + "\n");

		System.out.println("--delete \"Second\" element");
		unsortedList.delete(new ListString("Second"));
		anotherList.delete(new ListString("Second")); 

		System.out.println("Unsorted List");
		System.out.println("Forwards Order: " + ListDriver.print(unsortedList.elements()));
		System.out.println("Reverse Order: " + ListDriver.printReverse(unsortedList.elements()) + "\n");

		System.out.println("Another Unsorted List");
		System.out.println("Forwards Order: " + ListDriver.print(anotherList.elements()));
		System.out.println("Reverse Order: " + ListDriver.printReverse(anotherList.elements()) + "\n");
		
		System.out.println("--add \"Sixth\" element");		
		unsortedList.insert(new ListString("Sixth"));
		anotherList.insert(new ListString("Sixth"));
		
		System.out.println("Unsorted List");
		System.out.println("Forwards Order: " + ListDriver.print(unsortedList.elements()));
		System.out.println("Reverse Order: " + ListDriver.printReverse(unsortedList.elements()) + "\n");
		
		System.out.println("Another Unsorted List");
		System.out.println("Forwards Order: " + ListDriver.print(anotherList.elements()));
		System.out.println("Reverse Order: " + ListDriver.printReverse(anotherList.elements()) + "\n");
	}

	public static String print(NewListIterator L) {
		ListIterator li = (ListIterator)L;
		
		if(li.getNumElements() == 0) {
			return "";
		} 

		StringBuilder strList = new StringBuilder();
		
		li.reset();
		strList.append(li.getCurrItem());
		for(int i = 0; i < (li.getNumElements() - 1); i++) {
			strList.append(" " + li.getNextItem());
		}
		
		return strList.toString();
	}
	
	public static String printReverse(NewListIterator L) {
		ListIterator li = (ListIterator)L;

		if(li.getNumElements() == 0) {
			return "";
		} 

		StringBuilder strList = new StringBuilder();
		
		li.reset();
		strList.append(li.getPrevItem());
		for(int i = li.getNumElements() - 2; i >= 0; i--) {
			strList.append(" " + li.getPrevItem());
		}
		
		return strList.toString();
	}
}
