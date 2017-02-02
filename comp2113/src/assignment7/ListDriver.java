/**
 * 
 */

package assignment7;

import ch04.genericLists.*;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 07
 * Version:      1.0
 * File:         ListDriver.java
 *
 * Driver to test the DoubleLinkedList class 
 * 
 */

public class ListDriver {
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		String[] elements = new String[]{"First", "Second", "Third", "Fourth"};

		System.out.println("Trying to delete \"Empty\" from the empty list");
		list.delete(new ListString("Empty"));
		
		System.out.println("\nThe contents of the list are: " + print(list) + "\n");	
		
		System.out.println("Inserting \"Zeroth\" to the list");
		list.insert(new ListString("Zeroth"));
		
		System.out.println("\nThe contents of the list are: " + print(list) + "\n");
		
		System.out.println("Deleting \"Zeroth\" from the list");
		list.delete(new ListString("Zeroth"));
		
		System.out.println("\nThe contents of the list are: " + print(list) + "\n");

		for(String s : elements) {
			System.out.println("Adding " + s + " to the list.");
			list.insert(new ListString(s));
		}

		System.out.println("\nThe contents of the list are: " + print(list) + "\n");
		
		System.out.println("Adding \"Fourth\" to list");
		list.insert(new ListString("Fourth"));
		
		System.out.println("\nThe contents of the list are: " + print(list) + "\n");
		
		System.out.println("Deleting \"Fourth\" from the list");
		list.delete(new ListString("Fourth"));
		
		System.out.println("\nThe contents of the list are: " + print(list) + "\n");	
	}
	
	public static String print(DoubleLinkedList list) {
		Listable item;
		if(list.lengthIs() == 0) {
			return "";
		} 

		StringBuilder strList = new StringBuilder();
		
		list.reset();
		item = list.getNextItem();
		while(item != null) {
			strList.append(item + " ");
			item = list.getNextItem();
		}
		
		return strList.toString();		
	}	
}
