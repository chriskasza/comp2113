/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 04
 * Version:      1.0
 * File:         ListIterator.java
 *
 * Interface for iterating lists. 
 */
package Assignment4;

import ch04.genericLists.Listable;

public class ListIterator implements NewListIterator {
	private int currentPos = 0;
	private int numElements = 0;
	private Listable[] list;
	
	public ListIterator(Listable[] l) {
		list = l;
		for (Listable lstbl : list) {
			if(lstbl != null)
			{
				numElements++;
			}
		}
	}

	@Override
	public void reset() {
		currentPos = 0;
	}

	@Override
	public Listable getNextItem() {
		if(currentPos == (numElements - 1)) 
			currentPos = 0;
		else
			currentPos++;

		return list[currentPos].copy();
	}

	public Listable getPrevItem() {
		if (currentPos == 0)
			currentPos = numElements - 1;
		else
			currentPos--;

		return list[currentPos].copy();
	}
	
	public Listable getCurrItem() {
		return list[currentPos].copy();
	}

	public int getNumElements() {
		return numElements;
	}
	
}
