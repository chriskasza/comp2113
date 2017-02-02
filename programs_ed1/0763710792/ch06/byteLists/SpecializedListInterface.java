//----------------------------------------------------------------------------
// SpecializedListInterface.java     by Dale/Joyce/Weems             Chapter 6
//
// Interface for a class that implements a list of bytes.
// There can be duplicate elements on the list.
// The list has two special properties called the current forward position 
// and the current backward position — the positions of the next element 
// to be accessed by getNextItem and by getPriorItem during an iteration 
// through the list. Only resetForward and getNextItem affect the current 
// forward position. Only resetBackward and getPriorItem affect the current 
// backward position. Note that forward and backward iterations may be in
// progress at the same time.
//----------------------------------------------------------------------------

package ch06.byteLists;

public interface SpecializedListInterface
{
  public void resetForward();
  // Effect:         Initializes current forward position for this list.
  // Postcondition:  Current forward position is first element on this list.

  public byte getNextItem ();
  // Effect:         Returns the value of the byte at the current forward 
  //                 position on this list and advances the value of the 
  //                 current forward position
  // Preconditions:  Current forward position is defined.
  //                 There exists a list element at current forward position.
  //                 No list transformers have been called since most recent call.
  // Postconditions: Return value = (value of byte at current forward position)
  //                 If current forward position is the last element then 
  //                 current forward position is set to the beginning of this list, 
  //                 otherwise it is updated to the next position.

  public void resetBackward();
  // Effect:         Initializes current backward position for this list.
  // Postcondition:  Current backward position is first element on this list.

  public byte getPriorItem ();
  // Effect:         Returns the value of the byte at the current backward 
  //                 position on this list and advances the value of the 
  //                 current backward position (towards front of list)
  // Preconditions:  Current backward position is defined.
  //                 There exists a list element at current backward position.
  //                 No list transformers have been called since most recent call.
  // Postconditions: Return value = (value of byte at current backward position)
  //                 If current backward position is the first element then 
  //                 current backward position is set to the end of this list, 
  //                 otherwise it is updated to the prior position.

  public int lengthIs();
  // Effect:         Determines the number of elements on this list.
  // Postcondition:  Return value = number of elements on this list

  public void insertFront (byte item);
  // Effect:         Adds the value of item to the front of this list.
  // PostCondition:  Value of item is at the front of this list.

  public void insertEnd (byte item);
  // Effect:         Adds the value of item to the end of this list.
  // PostCondition:  Value of item is at the end of this list.

}




