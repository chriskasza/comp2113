/*
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  02
 * Version:       1.0
 * File:          StringListElement.java
 *
 * An element of a string list which is aware of the elements directly
 * before and after it.  All list elements will be unique.
 */

package assignment2;

public class StringListElement {
	protected String text;
	protected StringListElement textBefore;
	protected StringListElement textAfter;
	protected boolean isFirstNode;
	protected boolean isLastNode;

	public StringListElement(StringListElement newTextBefore, String newText, StringListElement newTextAfter) {
		text = newText;
		textBefore = newTextBefore;
		textAfter = newTextAfter;
	}
	
	public StringListElement(String newText, StringListElement newTextAfter) {
	// Constructor - element is added to the front of the list
		text = newText;
		textAfter = newTextAfter;
	}
	
	public StringListElement(StringListElement newTextBefore, String newText) {
	// Constructor - element is added to the end of the list
		text = newText;
		textBefore = newTextBefore;
	}

	public StringListElement(String newText) {
	// Constructor - new list, single element
		text = newText;
	}

	public void setTextBefore(StringListElement newTextBefore) {
		textBefore = newTextBefore;
	}

	public void setTextAfter(StringListElement newTextAfter) {
		textAfter = newTextAfter;
	}

	public StringListElement getNextElement() {
		return textAfter;
	}
	
	public StringListElement getPrevElement() {
		return textBefore;
	}
	
	public boolean isStart() {
		if(textBefore == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEnd() {
		if(textAfter == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return text;
	}
}