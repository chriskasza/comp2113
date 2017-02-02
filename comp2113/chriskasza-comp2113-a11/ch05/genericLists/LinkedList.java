//----------------------------------------------------------------------------
// LinkedList.java             by Dale/Joyce/Weems                   Chapter 5
//
// Defines all constructs for a reference-based list that do not depend on
// whether or not the list is kept sorted.
//----------------------------------------------------------------------------

package ch05.genericLists;

import ch04.genericLists.*;

public abstract class LinkedList implements ListInterface

{
  protected class ListNode 
  // Used to hold references to list nodes for the linked list implementation
  {
    protected Listable info;         // the info in a list node
    protected ListNode next;         // a link to the next node on the list
  }  
  
  protected ListNode list;           // reference to the first node on the list
  protected int numItems;            // Number of elements in the list
  protected ListNode currentPos;     // Current position for iteration

  public LinkedList()
  // Creates an empty list object.
  {
    numItems = 0;
    list = null;
    currentPos = null;
  }

  public boolean isFull()
  // Determines whether this list is full.
  {
    return false;
  }

  public int lengthIs()
  // Determines the number of elements on this list.
  {
    return numItems;
  }

  public abstract boolean isThere (Listable item);
  // Determines if element matching item is on this list.

  public Listable retrieve (Listable item)
  // Returns a copy of the list element with the same key as item.
  {
    ListNode location = list;
    boolean found = false;

    while (!found)
    {
      if (item.compareTo(location.info) == 0)    // if they match
        found = true;
      else
        location = location.next;
    }

    return location.info.copy();
  } 

  public abstract void insert (Listable item);
  // Adds a copy of item to this list. 

  public void delete (Listable item)
  // Deletes the element of this list whose key matches item’s key.
  {
    ListNode location = list;

    // Locate node to be deleted.
    if (item.compareTo(location.info) == 0)
      list = list.next;                         // Delete first node.
    else
      {
      while (item.compareTo(location.next.info) != 0)
        location = location.next;
      // Delete node at location.next.
      location.next = location.next.next;
      }
    numItems--;
  }

  public void reset()
  // Initializes current position for an iteration through this list. 
  {
    currentPos  = list;
  }

  public Listable getNextItem ()
  // Returns copy of the next element in list. 
  {
    Listable nextItemInfo = currentPos.info.copy();
    if (currentPos.next == null)
      currentPos = list;
    else 
      currentPos = currentPos.next;

    return nextItemInfo;
  }

}