//----------------------------------------------------------------------------
// LinkedStack.java            by Dale/Joyce/Weems                   Chapter 5
//
// Implements StackInterface using a linked list to hold the stack items
//----------------------------------------------------------------------------

package ch05.stacks;

import ch04.stacks.*;

public class LinkedStack implements StackInterface
{

  private class StackNode
  // Used to hold references to stack nodes for the linked stack implementation
  {
    private Object info;
    private StackNode link;
  }

  private StackNode top;   // reference to the top of this stack

  public LinkedStack()
  // Constructor
  {
    top = null;
  }

  public void push(Object item)
  // Adds an element to the top of this stack
  { 
    StackNode newNode = new StackNode();
    newNode.info = item;
    newNode.link = top;
    top = newNode;
  }     

  public void pop()
  // Removes an element from the top of this stack
  {                  
    if (!isEmpty())
    {
      top = top.link;
    }
    else
      throw new StackUnderflowException("Pop attempted on an empty stack.");
  }

  public Object top()
  // Returns the element on top of this stack
  {                 
    if (!isEmpty())
      return top.info;
    else
      throw new StackUnderflowException("Top attempted on an empty stack.");
  }

  public boolean isEmpty()
  // Checks if this stack is empty
  {              
    if (top == null) 
      return true;
    else
      return false;
  }

  public boolean isFull()
  // Checks if this stack is full
  {              
      return false;
  }
}

