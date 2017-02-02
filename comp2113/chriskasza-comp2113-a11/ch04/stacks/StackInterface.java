//----------------------------------------------------------------------------
// StackInterface.java           by Dale/Joyce/Weems                 Chapter 4
//
// Interface for a class that implements a stack of Objects.
// A stack is a last-in, first-out structure.
//----------------------------------------------------------------------------

package ch04.stacks;

public interface StackInterface

{
  public void push(Object item) throws StackOverflowException;
  // Effect:         Adds item to the top of this stack.
  // Postcondition:  If (this stack is full)
  //                    an unchecked exception that communicates 
  //                    'push on stack full' is thrown
  //                 else
  //                    item is at the top of this stack.

  public void pop() throws StackUnderflowException;
  // Effect:         Removes top item from this stack
  // Postconditions: If (this stack is empty)
  //                   an unchecked exception that communicates 
  //                   'pop on stack empty' is thrown
  //                 else
  //                   top element has been removed from this stack.

  public Object top() throws StackUnderflowException;
  // Effect:         Returns a reference to the element on top of this stack
  // Postconditions: If (this stack is empty)
  //                    an unchecked exception that communicates 
  //                   'top on stack empty' is thrown
  //                 else
  //                   return value = (top element of this stack).

  public boolean isEmpty();
  // Effect:         Determines whether this stack is empty.
  // Postcondition:  Return value = (this stack is empty)

  public boolean isFull();
  // Effect:         Determines whether this stack is full.
  // Postcondition:  Return value = (stack is full)
}
