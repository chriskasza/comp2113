package ch06.genericLists;

import ch04.genericLists.*;

public interface TwoWayListInterface extends ListInterface

// Interface for a class that implements a list of elements as defined
// by ListInterface, with the additional operation(s) defined below

{
  public Listable getPreviousItem ();
  // Effect:         Returns a copy of the element preceding the current position on
  //                 this list and moves back the value of the current position.
  //                 The last element precedes the first element.
  // Preconditions:  Current position is defined.
  //                 There exists a list element preceding current position.
  //                 No list transformers have been called since most recent call to reset.
  // Postconditions: Return value = (a copy of element previous to current position)
}




