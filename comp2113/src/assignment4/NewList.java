/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 04
 * Version:      1.0
 * File:         NewList.java
 *
 * Abstract class for an array-based list.
 */
package Assignment4;

import ch04.genericLists.*;

public abstract class NewList implements NewListInterface
{
	protected Listable[] list;          // Array to hold this list’s elements
	protected int numItems;             // Number of elements in this list
	protected int currentPos;           // Current position for iteration

	public NewList(int maxItems)
	// Instantiates and returns a reference to an empty list object with room for maxItems elements.
	{	
		numItems = 0;
		list = new Listable[maxItems];
	}

	public boolean isFull()
	// Returns whether this list is full. 
	{
		return (list.length == numItems);
	}

	public int lengthIs()
	// Returns the number of elements in this list. 
	{
		return numItems;
	}

	public abstract boolean isThere (Listable item);
	// Returns true if an element with the same key as item is on this list, otherwise returns false.
	
	public abstract Listable retrieve(Listable item);
	// Returns a copy of the list element with the same key as item

	public abstract void insert (Listable item);
	// Adds a copy of item to this list. 
	
	public abstract void delete (Listable item);
	// Deletes the element with the same key as  item from this list. 
	
	public NewListIterator elements()
	// Initializes current position for an iteration through this list. 
	{
		NewListIterator listIterator = new ListIterator(list);
		return listIterator;
	}
}
