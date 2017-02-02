/**
 * 
 */

package assignment7;

import ch04.genericLists.Listable;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 07
 * Version:      1.0
 * File:         Set.java
 *
 * Interface for a Set ADT
 * 
 */

public class Set extends DoubleLinkedList {
	/**
	 * Method:         Set()
	 * Postcondition:  Instantiates an empty Set object.
	 */
	public Set() {
		super();
	}

	/**
	 * Method:         union(a, b)
	 * Precondition:   union requires two Set objects containing elements 
	 *                 of the same type to be passed to it.
	 * Postcondition:  A new Set object is created containing all of the
	 *                 elements that exist in both of the parameter Set objects
	 * @param setA:    setA needs to be a Set object.
	 * @param setB:    setB needs to be a Set object.
	 * @throws         IllegalArgumentException if the type of the elements 
	 *                 in the parameter Set objects are not the same.
	 * @return:        A new Set object is returned containing the union of 
	 *                 the two parameters, setA and setB.
	 */
	public static Set union(Set setA, Set setB) throws IllegalArgumentException {
		Listable setAItem, setBItem;
		Set setC = new Set();
		
		if(setA.numItems == 0) {
			setC.assign(setB);
		} 
		else if(setB.numItems == 0) {
			setC.assign(setA);
		}
		
		setA.reset();
		setB.reset();
		setAItem = setA.getNextItem();
		setBItem = setB.getNextItem();
		if(!setAItem.getClass().equals(setBItem.getClass())) {
			throw new IllegalArgumentException("Type mismatch between elements in setA and setB.");
		}

		while(setAItem != null) {
			setC.insert(setAItem.copy());
			
			setAItem = setA.getNextItem();
		}

		while(setBItem != null) {
			if(!setA.isThere(setBItem)) {
				setC.insert(setBItem.copy());
			}
			
			setBItem = setB.getNextItem();
		}
		
		return setC;
	}
	
	/**
	 * Method:         intersection(a, b)
	 * Precondition:   intersection requires two Set objects containing elements
	 *                 of the same type to be passed to it
	 * Postcondition:  If there are no elements that exist in both of the Set
	 *                 parameter objects
	 *                     an empty Set object will be returned
	 *                 If there are elements that exist in both of the Set
	 *                 parameter objects
	 *                     a Set object containing those elements is returned
	 * @param setA:    setA needs to be a Set object.
	 * @param setB:    setB needs to be a Set object.
	 * @throws         IllegalArgumentException if the type of the elements 
	 *                 in the parameter Set objects are not the same.
	 * @return         A new Set object is returned containing the intersection 
	 *                 of the two parameters, setA and setB.
	 */
	public static Set intersection(Set setA, Set setB) throws IllegalArgumentException {
		Listable setAItem, setBItem;
		Set setC = new Set();
		
		setA.reset();
		setB.reset();
		setAItem = setA.getNextItem();
		setBItem = setB.getNextItem();
		if(!setAItem.getClass().equals(setBItem.getClass())) {
			throw new IllegalArgumentException("Type mismatch between elements in setA and setB.");
		}
		
		while(setAItem != null) {
			if(setB.isThere(setAItem)) {
				setC.insert(setAItem.copy());
			}

			setAItem = setA.getNextItem();
		}
		
		return setC;
	}

	/**
	 * Method:         difference(a, b)
	 * Precondition:   difference requires two Set objects containing elements
	 *                 of the same type to be passed to it.
	 * Postcondition:  If all elements that are present in the parameter setA
	 *                 also exist in the parameter setB
	 *                     an empty Set object will be returned
	 *                 If there are elements that exist in one of the parameter
	 *                 Set objects but not the other
	 *                     a Set object containing those elements is returned
	 * @param setA:    setA needs to be a Set object.
	 * @param setB:    setB needs to be a Set object.
	 * @throws         IllegalArgumentException if the type of the elements 
	 *                 in the parameter Set objects are not the same.
	 * @return         A new Set object is returned containing the elements 
	 *                 that exist in only one of the two parameters, setA or 
	 *                 setB.
	 */
	public static Set difference(Set setA, Set setB) throws IllegalArgumentException {
		Listable setAItem, setBItem;
		Set setC = new Set();
		
		setA.reset();
		setB.reset();
		setAItem = setA.getNextItem();
		setBItem = setB.getNextItem();
		if(!setAItem.getClass().equals(setBItem.getClass())) {
			throw new IllegalArgumentException("Type mismatch between elements in setA and setB.");
		}

		while(setAItem != null) {
			if(!setB.isThere(setAItem)) {
				setC.insert(setAItem.copy());
			}
			
			setAItem = setA.getNextItem();
		}
		
		while(setBItem != null) {
			if(!setA.isThere(setBItem)) {
				setC.insert(setBItem.copy());
			}
			
			setBItem = setB.getNextItem();
		}
		return setC;
	}

	/**
	 * Method:         equal(setA, setB)
	 * @param setA:    setA needs to be a Set object.
	 * @param setB:    setB needs to be a Set object.
	 * @return         true if setA has the same elements as setB and vice versa
	 *                 false if setA does not have the same elements as setB or vice versa
	 */
	public static boolean equal(Set setA, Set setB) {
		Listable setAItem;
		setA.reset();
		setB.reset();

		if(!(setA.numItems == setB.numItems)) {
			return false;
		}
		
		setAItem = setA.getNextItem();
		while(setB.isThere(setAItem)) {
			setAItem = setA.getNextItem();
			if(setAItem == null) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Method:         member(item)
	 * Precondition:   item needs to be a Listable type
	 * Postcondition:  will return true or false depending on whether item is in this set
	 * @param item:    item needs to be a Listable type
	 * @return:        true if item is in the set
	 *                 false if it is not
	 */
	public boolean member(Listable item) {
		return isThere(item);
	}
	
	/**
	 * Method:         makeNull() - inherited from DoubleLinkedList
	 * Postcondition:  empties the set
	 */

	/**
	 * Method:         assign(setA, setB)
	 * Postcondition:  copies all elements in setA to setB
	 * @param setA:    setA needs to be a Set object.
	 * @param setB:    setB needs to be a Set object.
	 */
	public void assign(Set otherSet) {
		Listable item;
		
		this.makeNull();
		otherSet.reset();
		
		item = otherSet.getNextItem();
		while(item != null) {		
			this.insert(item.copy());
			item = otherSet.getNextItem();
		}
	}
	
	/**
	 *  Method:         insert(item) - inherited from DoubleLinkedList 
	 *  Precondition:   item is a type that implements interface, Listable
	 *                  item is the same type as other items in the set
	 *  Postcondition:  item is added to the set
	 *  @param item:    item needs to be a type that implements Listable
	 */
	
	/**
	 *  Method:         delete(item) - inherited from DoubleLinkedList
	 *  Precondition:   item is a type that implements interface, Listable
	 *                  item is the same type as other items in the set
	 *  Postcondition:  if exists, item is removed from the set
	 *  @param item:    item needs to be a type that implements Listable
	 */
}
