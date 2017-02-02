/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 03
 * Version:      1.0
 * File:         UnsortedList.java
 *
 * Class for a generic unsorted list.  Order is not preserved.
 * 
 */
package Assignment4;

import ch04.genericLists.*;

public class UnsortedList extends NewList {
	private int foundIndex = -1;
	
	protected boolean found = false;
	/**
	 * Constructor for empty list; default size is 100.
	 */
	public UnsortedList() {
		this(100);
	}
	
	/**
	 * Constructor that initializes a list with the specified size
	 * @param newSize The initial size of the list
	 * @throws java.lang.IllegalArgumentException if the specified size is negative
	 */
	public UnsortedList(int size) {
		super(size);
		if(size < 0) {
			throw new IllegalArgumentException("Illegal list size: " + size);
		}
	}

	/**
	 * Returns true if an element with the same key as item is on this list, otherwise returns false.
	 * @param item element to search for
	 * @return true if element is found in the list
	 *         false if no element is found
	 */
	public boolean isThere(Listable item) {
		for(int i = 0; i < numItems; i++) {
			if((item.compareTo(list[i])) == 0) { //match
				foundIndex = i;
				return true;
			}
		}
		foundIndex = -1;
		return false;
	}

	/**
	 * Returns a copy of the list element with the same key as item
	 * @param element the element to be found
	 * @return Listable element if found
	 *         null if element not found
	 */
	
	public Listable retrieve(Listable item) {
		for(int i = 0; i < numItems; i++) {
			if((item.compareTo(list[i])) == 0) { //match
				return list[i].copy();
			}
		}
		return null;
	}
	
	/**
	 * Adds a copy of item to this list.
	 * @param item the element to be added to the list
	 */
	public void insert(Listable item) {
		if(!isFull()) {
			list[numItems] = item.copy();
			numItems++;
		} else {
			throw new IllegalStateException("List array is full.");
		}
	}
	
	/**
	 * Deletes the element with the same key as  item from this list.
	 * @param item the element to be deleted from the list
	 */
	public void delete(Listable item) {
		if(isThere(item)) {
			list[foundIndex] = list[numItems - 1];
			list[numItems - 1] = null;
			numItems--;
			foundIndex = -1;
		}
	}
}