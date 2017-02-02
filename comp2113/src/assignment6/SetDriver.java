/**
 * 
 */

package assignment6;

import ch04.genericLists.*;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 06
 * Version:      1.0
 * File:         SetDriver.java
 *
 * Driver to test the Set ADT class 
 * 
 */

public class SetDriver {
	public static void main(String[] args) {
		Set set1 = new Set();
		Set set2 = new Set();
		String[] elements = new String[]{"First", "Second", "Third", "Fourth", "Fifth"};
		
		for(String s : elements) {
			System.out.println("Adding " + s + " to Set 1 and Set 2.");
			set1.insert(new ListString(s));
			set2.insert(new ListString(s));
		}

		if(Set.equal(set1, set2)) {
			System.out.println("\nSet 1 has the same elements as Set 2\n");
		} else {
			System.out.println("\nSet 1 has different elements than Set 2\n");
		}		
		
		System.out.println("Adding \"Sixth\" to Set 1");
		set1.insert(new ListString("Sixth"));
		System.out.println("Adding \"Seventh\" to Set 2");
		set2.insert(new ListString("Seventh"));
		
		if(Set.equal(set1, set2)) {
			System.out.println("\nSet 1 has the same elements as Set 2\n");
		} else {
			System.out.println("\nSet 1 has different elements than Set 2\n");
		}	
		
		Set set3 = Set.difference(set1, set2);
		System.out.println("The difference between Set 1 and Set 2 is: " + printSet(set3));
		
		set3 = Set.union(set1, set2);
		System.out.println("The union of Set 1 and Set 2 is: " + printSet(set3));

		set3 = Set.intersection(set1, set2);
		System.out.println("The intersection of Set 1 and Set 2 is: " + printSet(set3));
		
		System.out.println("Assign Set 1 to Set 2");
		set2.assign(set1);
		if(Set.equal(set1, set2)) {
			System.out.println("\nSet 1 has the same elements as Set 2\n");
		} else {
			System.out.println("\nSet 1 has different elements than Set 2\n");
		}
		
		System.out.println("The contents of Set 1 are: " + printSet(set1));
		System.out.println("The contents of Set 2 are: " + printSet(set2));
	}
	
	public static String printSet(Set set) {
		Listable item, head;
		if(set.lengthIs() == 0) {
			return "";
		} 

		StringBuilder strList = new StringBuilder();
		
		set.reset();
		head = set.getNextItem();
		strList.append(head);
		while(true) {
			item = set.getNextItem();
			if(item.compareTo(head) == 0) {
				break;
			}
			strList.append(" " + item);
		}
		
		return strList.toString();		
	}	
}
