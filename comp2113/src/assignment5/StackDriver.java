/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 03
 * Version:      1.0
 * File:         StackDriver.java
 *
 * Driver for the ArrayListStack and CopyArrayListStack classes
 * 
 */
package assignment5;

import ch04.genericLists.*;
import ch04.stacks.StackUnderflowException;


public class StackDriver {

	public static void main(String[] args) {
		ArrayListStack refStack = new ArrayListStack();
		CopyArrayListStack copyStack = new CopyArrayListStack();
		
		System.out.println("Creating an array of three string elements: First, Second, Third.");
		EditableListString elements[] = {new EditableListString("First"), new EditableListString("Second"), new EditableListString("Third")};

		for(EditableListString s : elements) {
			System.out.println("Pushing \"" + s + "\" onto the Reference Stack and Copy Stack.");
			refStack.push(s);
			copyStack.push(s);
		}
		
		System.out.println("\nChanging the second item in the array from \"Second\" to \"two\".\n");
		elements[1].setKey("two");
		
		System.out.println("Top element on the ");
		System.out.println("Reference Stack: " + refStack.top());
		System.out.println("Copy Stack: " + copyStack.top());

		System.out.println("\nPop the top element off the stacks.");
		refStack.pop();
		copyStack.pop();
		System.out.println("Top element on the ");
		System.out.println("Reference Stack: " + refStack.top());
		System.out.println("Copy Stack: " + copyStack.top());
		
		System.out.println("\nPop the top element off the stacks.");
		refStack.pop();
		copyStack.pop();
		System.out.println("Top element on the ");
		System.out.println("Reference Stack: " + refStack.top());
		System.out.println("Copy Stack: " + copyStack.top());


		System.out.println("\nPop the top element off the stacks.");
		refStack.pop();
		copyStack.pop();
		try {
			System.out.println("Try to get the top Reference Stack item: " + refStack.top());
		} catch (StackUnderflowException e) {
			System.out.println("Nothing left on the Reference Stack.");
		}
		try {
			System.out.println("The top Copy Stack item: " + copyStack.top());
		} catch (StackUnderflowException e) {
			System.out.println("Nothing left on the Copy Stack.");
		}

		System.out.println("\nTry to pop an element off the empty stacks.");
		try {
			refStack.pop();
		} catch (StackUnderflowException e) {
			System.out.println("The Reference Stack cannot be popped anymore because it is empty.");
		}
		try {
			copyStack.pop();
		} catch (StackUnderflowException e) {
			System.out.println("The Copy Stack cannot be popped anymore because it is empty.");
		}		
	}	
}
