/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 04
 * Version:      1.0
 * File:         NewListInterface.java
 *
 * Interface for a class that implements a list of unique elements, i.e., 
 * no duplicate elements as defined by the key of the list. 
 */
package Assignment4;

import ch04.genericLists.Listable;

public interface NewListInterface {
	public boolean isFull();
	// Effect:        Determines whether this list is full.
	// Postcondition: Return value = (this list is full)

	public int lengthIs();
	// Effect:        Determines the number of elements on this list.
	// Postcondition: Return value = number of elements on this list

	public boolean isThere (Listable item);
	// Effect:        Determines if element matching item is on this list.
	// Postcondition: Return value = (element with the same key as item is on this list)
	
	public Listable retrieve(Listable item);
	// Effect:        Returns a copy of the list element with the same key as item.
	// Preconditions: Item is on this list.
	// Postcondition: Return value = (list element that matches item)

	public void insert (Listable item);
	// Effect:        Adds a copy of item to this list.
	// Preconditions: This list is not full.
	//                Element matching item is not on this list.
	// Postcondition: Copy of item is on this list. 
	
	public void delete (Listable item);
	// Effect:        Deletes the element of this list whose key matches item's key.
	// Preconditions: One and only one element on list has a key matching item's key.
	// Postcondition: No element on list has a key matching the argument item's key.	
}
