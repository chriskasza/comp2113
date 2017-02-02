/*
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  02
 * Version:       1.0
 * File:          EditorStringList.java
 *
 * Class to edit a list of strings (add, delete, etc)
 */

package assignment2;

import java.util.*;

public class EditorStringList {
	protected HashMap<String, StringListElement> stringList = new HashMap<String, StringListElement>();
	protected StringListElement start = new StringListElement("start");
	protected StringListElement end = new StringListElement("end");

	// Constructor -  create an empty list	
	public EditorStringList() {
		start.setTextAfter(end);
		end.setTextBefore(start);
	}
	
	// Constructor -  create a new list with one element
	public EditorStringList(String source) {
		stringList.put(source, new StringListElement(source));
		start.setTextAfter(stringList.get(source));
		end.setTextBefore(stringList.get(source));
	}

	public void insertAfter(String source, String destination) {
		// if destination isn't found; insert at end of list?
		StringListElement before = stringList.get(destination);
		StringListElement after = stringList.get(destination).getNextElement();
		stringList.put(source, new StringListElement(before, source, after));
		before.setTextAfter(stringList.get(source));
		if(stringList.get(source).getNextElement() == null) {
			end.setTextBefore(stringList.get(source));
		} else {
			after.setTextBefore(stringList.get(source));
		}
	}

	public void insertBefore(String source, String destination) {
		StringListElement after = stringList.get(destination);
		StringListElement before = stringList.get(destination).getPrevElement();
		stringList.put(source, new StringListElement(before, source, after));
		after.setTextBefore(stringList.get(source));
		if(stringList.get(source).getPrevElement() == null) {
			start.setTextAfter(stringList.get(source));
		} else {
			before.setTextAfter(stringList.get(source));
		}
	}

	public void insertFront(String source) {		
		StringListElement before = start;
		StringListElement after = start.getNextElement();
		
		if(after == end) {
			// empty list
			stringList.put(source, new StringListElement(source));
		} else {
			stringList.put(source, new StringListElement(source, after));		
		}

		start.setTextAfter(stringList.get(source));

		if(stringList.get(source).getNextElement() == null) {
			end.setTextBefore(stringList.get(source));
		} else {
			after.setTextBefore(stringList.get(source));
		}		
	}
	
	public void insertEnd(String source) {		
		StringListElement after = end;
		StringListElement before = end.getPrevElement();
		
		if(before == start) {
			// empty list
			stringList.put(source, new StringListElement(source));
		} else {
			stringList.put(source, new StringListElement(before, source));		
		}

		end.setTextBefore(stringList.get(source));

		if(stringList.get(source).getPrevElement() == null) {
			start.setTextAfter(stringList.get(source));
		} else {
			before.setTextAfter(stringList.get(source));
		}		
	}	

	public void remove(String source) {
		StringListElement toDelete = stringList.get(source);

		if((toDelete.getPrevElement() == null) && (toDelete.getNextElement() == null)) {
			// single entry in list
			start.setTextAfter(end);
			end.setTextBefore(start);
		} else if(toDelete.getNextElement() == null) {
			// last entry in list
			toDelete.getPrevElement().setTextAfter(toDelete.getNextElement());
			end.setTextBefore(toDelete.getPrevElement());
		}  else if(toDelete.getPrevElement() == null) {
			// first entry in list
			start.setTextAfter(toDelete.getNextElement());
			toDelete.getNextElement().setTextBefore(toDelete.getPrevElement());
		} else {
			// entry in middle of list
			toDelete.getPrevElement().setTextAfter(toDelete.getNextElement());
			toDelete.getNextElement().setTextBefore(toDelete.getPrevElement());
		}
		stringList.remove(source);
	}

	public String print(StringListElement element) {
		if(isEmpty()) {
			return "";
		} else {
			if(element.getNextElement() == null) {
				return element.toString();
			} else {
				return (element.toString() + " " + print(element.getNextElement()));
			}
		}
	}

	public String revPrint(StringListElement element) {
		if(isEmpty()) {
			return "";
		} else {
			if(element.getPrevElement() == null) {
				return element.toString();
			} else {
				return (element.toString() + " " + revPrint(element.getPrevElement()));				
			}
		}
	}

	public boolean exists(String source) {
		if(stringList.containsKey(source)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(start.getNextElement() == end) {
			return true;
		} else {
			return false;
		}
	}

	public StringListElement getFirstElement() {
		if(isEmpty()) {
			return null;
		} else {
			return start.getNextElement();
		}
	}
	
	public StringListElement getLastElement() {
		if(isEmpty()) {
			return null;
		} else {
			return end.getPrevElement();
		}
	}	
}
