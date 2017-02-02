/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 04
 * Version:      1.0
 * File:         NewListIterator.java
 *
 * Interface for iterating lists. 
 */
package Assignment4;

import ch04.genericLists.Listable;

public interface NewListIterator {
	public void reset();
	// Effect:        Initializes current position for an iteration through this list.
	// Postcondition: Current position is first element on this list.

	public Listable getNextItem ();
	// Effect:        Returns a copy of the element at the current position on this list 
	//                and advances the value of the current position
	// Preconditions: Current position is defined.
	//                There exists a list element at current position.
	//                No list transformers called since most recent call to reset.
	// Postconditions: Return value = (a copy of element at current position)
	//                 If current position is the last element then current position is
	//                 set to the beginning of this list, otherwise it is updated to 
	//                 the next position.
}
