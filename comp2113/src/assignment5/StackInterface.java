//----------------------------------------------------------------------------
// StackInterface.java           by Dale/Joyce/Weems                 Chapter 4
//
// Interface for a class that implements a stack of Objects.
// A stack is a last-in, first-out structure.
//----------------------------------------------------------------------------

package assignment5;

import ch04.stacks.StackOverflowException;
import ch04.stacks.StackUnderflowException;

public interface StackInterface extends GeneralStackInterface {
	public void push(Object item) throws StackOverflowException;
	// Effect:         Adds item to the top of this stack.
	// Postcondition:  If (this stack is full)
	//                    an unchecked exception that communicates 
	//                    'push on stack full' is thrown
	//                 else
	//                    item is at the top of this stack.

	public Object top() throws StackUnderflowException;
	// Effect:         Returns a reference to the element on top of this stack
	// Postconditions: If (this stack is empty)
	//                    an unchecked exception that communicates 
	//                   'top on stack empty' is thrown
	//                 else
	//                   return value = (top element of this stack).

}
