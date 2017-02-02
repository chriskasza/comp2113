//----------------------------------------------------------------------------
// ArrayStack.java             by Dale/Joyce/Weems                   Chapter 4
//
// Implements StackInterface using an array to hold the stack items
//----------------------------------------------------------------------------

package ch04.stacks;

public class ArrayStack implements StackInterface 
{
  private Object[] stack;           // Array that holds stack elements
  private int topIndex = -1;        // index of top element in stack

  // Constructors
  public ArrayStack() 
  {
    stack = new Object[100];
  }

  public ArrayStack(int maxSize) 
  {
    stack = new Object[maxSize];
  }

  public void push(Object item)
  // Adds an element to the top of this stack
  {      
    if (!isFull())
    {
      topIndex++;
      stack[topIndex] = item;
    }
    else
      throw new StackOverflowException("Push attempted on a full stack.");
  }

  public void pop()
  // Removes an element from the top of this stack
  {                  
    if (!isEmpty())
    {
      stack[topIndex] = null;
      topIndex--;
    }
    else
      throw new StackUnderflowException("Pop attempted on an empty stack.");
  }

  public Object top()
  // Returns the element on top of this stack
  {                 
    Object topOfStack = null;
    if (!isEmpty())
      topOfStack = stack[topIndex];
    else
      throw new StackUnderflowException("Top attempted on an empty stack.");
    return topOfStack;
  }

  public boolean isEmpty()
  // Checks if this stack is empty
  {              
    if (topIndex == -1) 
      return true;
    else
      return false;
  }

  public boolean isFull()
  // Checks if this stack is full
  {              
    if (topIndex == (stack.length - 1)) 
      return true;
    else
      return false;
  }
}