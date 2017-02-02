//----------------------------------------------------------------------------
// ArrayListStack.java           by Dale/Joyce/Weems                 Chapter 4
//
// Implements StackInterface using an ArrayList to hold the stack items
//----------------------------------------------------------------------------

package assignment5;

import java.util.*;
import ch04.genericLists.*;
import ch04.stacks.*;

public class CopyArrayListStack implements CopyStackInterface
{
	private ArrayList<Listable> stack;        // ArrayList that holds stack elements

	// Constructor
	public CopyArrayListStack() 
	{
		stack = new ArrayList<Listable>();      
	}

	public void push(Object item)   
	// Adds an element to the top of this stack
	{
		if(!(item instanceof Listable)) throw new ClassCastException();
		stack.add(((Listable)item).copy());
	}
	
	public void pop()               
	// Removes an element from the top of this stack
	{
		if (!isEmpty())
		{
			stack.remove(stack.size() - 1);
		}
		else 
			throw new StackUnderflowException("Pop attempted on an empty stack.");
	}

	public Object top()             
	// Returns the top element from this stack
	{
		Listable topOfStack = null;
		if (!isEmpty())
			topOfStack = stack.get(stack.size() - 1);
		else 
			throw new StackUnderflowException("Top attempted on an empty stack.");    
		return topOfStack;
	}

	public boolean isEmpty()         
	// Checks if this stack is empty
	{
		if (stack.size() == 0)
			return true;
		else 
			return false;
	}

	public boolean isFull()
	// Checks if this stack is full
	// Assumes stack is never full since ArrayList implementation can grow as needed
	{
		return false;
	}
}