//----------------------------------------------------------------------------
// StringList.java             by Dale/Joyce/Weems                   Chapter 3
//
// Defines all constructs for an array based list that do not depend
// on whether or not the list is sorted
//----------------------------------------------------------------------------

package ch03.stringLists;

public abstract class StringList
{
  protected String[] list;            // Array to hold this list’s elements
  protected int numItems;             // Number of elements in this list
  protected int currentPos;           // Current position for iteration

  public StringList(int maxItems)
  // Instantiates and returns a reference to an empty list object with room for maxItems elements.
  {
    numItems = 0;
    list = new String[maxItems];
  }

  public boolean isFull()
  // Returns whether this list is full. 
  {
    return (list.length == numItems);
  }

  public int lengthIs()
  // Returns the number of elements in this list. 
  {
    return numItems;
  }

  public abstract boolean isThere (String item);
  // Returns true if item is on this list, otherwise returns false.
  
  public abstract void insert (String item);
  // Adds a copy of item to this list. 
  
  public abstract void delete (String item);
  // Deletes the element that matches item from this list. 
  
  public void reset()
  // Initializes current position for an iteration through this list. 
  {
    currentPos  = 0;
  }

  public String getNextItem ()
  // Returns copy of the next element in this list. 
  {
    String next = list[currentPos];
    if (currentPos == numItems-1)
      currentPos = 0;
    else
      currentPos++;
    return new String(next);
  }

}
