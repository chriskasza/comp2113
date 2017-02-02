//----------------------------------------------------------------------------
// UnsortedStringList3.java        by Dale/Joyce/Weems               Chapter 7
//
// Completes the definition of the StringList class under the assumption
// that the list is not kept sorted.
//
// Uses a recursive isThere method implementation
//----------------------------------------------------------------------------

package ch07.stringLists;

public class UnsortedStringList3

{
  protected String[] list;            // Array to hold list elements
  protected int numItems;             // Number of elements in this list
  protected int currentPos;           // Current position for iteration

  public UnsortedStringList3(int maxItems)
  // Instantiates and returns a reference to an empty list object with room for maxItems elements
  {
    numItems = 0;
    list = new String[maxItems];
  }

  public UnsortedStringList3()
  // Instantiates and returns a reference to an empty list object with room for 100 elements.
  {
    numItems = 0;
    list = new String[100];
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

  public boolean isThere (String item, int startPosition)
  // Returns true if item is on this list, otherwise returns false.
  {
    if (item.compareTo(list[startPosition]) == 0)  // if they match    
      return true;
    else if (startPosition == (numItems - 1))
      return false;
    else return isThere(item, startPosition + 1);
  }

  public void insert (String item)
  // Adds a copy of item to this list. 
  {
    list[numItems] = new String(item);
    numItems++;
  }

  public void delete (String item)
  // Deletes the element that matches item from this list. 
  {
    int location = 0;

    while (item.compareTo(list[location]) != 0)
      location++;

    list[location] = list[numItems - 1];
    numItems--;
  }

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