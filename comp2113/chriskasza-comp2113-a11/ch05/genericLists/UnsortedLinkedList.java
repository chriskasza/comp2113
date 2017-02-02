//----------------------------------------------------------------------------
// UnsortedLinkedList.java         by Dale/Joyce/Weems               Chapter 5
//
// Completes the definition of a reference-based list under the assumption
// that the list is not kept sorted.
//----------------------------------------------------------------------------

package ch05.genericLists;

import ch04.genericLists.*;

public class UnsortedLinkedList extends LinkedList
{
  public UnsortedLinkedList()
  // Instantiates an empty list object.
  {
    super();
  }

  public boolean isThere (Listable item)
  // Determines if element matching item is on this list.
  {
    boolean moreToSearch;
    ListNode location = list;
    boolean found = false;

    moreToSearch = (location != null);

    while (moreToSearch && !found) 
    {
      if (item.compareTo(location.info) == 0)  // if they match
        found = true;
      else
      {
        location = location.next;
        moreToSearch = (location != null);
      }
    }

   return found;
  }

  public void insert (Listable item)
  // Adds a copy of item to this list. 
  {
    ListNode newNode = new ListNode();
    newNode.info = (Listable)item.copy();
    newNode.next = list;
    list = newNode;
    numItems++;
  }

}