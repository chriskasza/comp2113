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
package Assignment3;

import ch04.genericLists.*;


public class ListDriver {

	public static void main(String[] args) {
		List unsortedList = new UnsortedList();
		List anotherList = new AnotherUnsortedList();		
		String[] elements = new String[]{"First", "Second", "Third", "Fourth", "Fifth"};
		
		for(String s : elements) {
			unsortedList.insert(new ListString(s));
			anotherList.insert(new ListString(s));
		}
		
		unsortedList.delete(new ListString("Second"));
		anotherList.delete(new ListString("Second")); 
		unsortedList.insert(new ListString("Sixth"));
		anotherList.insert(new ListString("Sixth"));
		
		System.out.println("Unsorted List");
		System.out.println("Forwards Order:" + ListDriver.print(unsortedList));
		System.out.println("Reverse Order:" + ListDriver.printReverse(unsortedList) + "\n");
		
		System.out.println("Another Unsorted List");
		System.out.println("Forwards Order:" + ListDriver.print(anotherList));
		System.out.println("Reverse Order:" + ListDriver.printReverse(anotherList) + "\n");
	}

	public static String print(ListInterface L) {
		if(L.lengthIs() == 0) {
			return "";
		} 

		StringBuilder strList = new StringBuilder();
		
		L.reset();
		strList.append(L.getNextItem());
		for(int i = 0; i < (L.lengthIs()-1); i++) {
			strList.append(" " + L.getNextItem());
		}
		
		return strList.toString();
	}
	
	public static String printReverse(ListInterface L) {
		if(L.lengthIs() == 0) {
			return "";
		} 

		StringBuilder strList = new StringBuilder();
		
		L.reset();
		strList.append(L.getNextItem());
		for(int i = 0; i < (L.lengthIs()-1); i++) {
			strList.insert(0, L.getNextItem() + " ");
		}
		
		return strList.toString();
	}
}
