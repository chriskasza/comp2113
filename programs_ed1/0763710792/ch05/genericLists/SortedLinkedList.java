//----------------------------------------------------------------------------
// SortedLinkedList.java          by Dale/Joyce/Weems                Chapter 5
//
// Completes the definition of an link-based list under the assumption
// that the list is kept sorted.
//----------------------------------------------------------------------------

package ch05.genericLists;

import ch04.genericLists.*;

public class SortedLinkedList extends LinkedList
{
  public SortedLinkedList()
  // Instantiates an empty list object.
  {
    super();
  }

  public boolean isThere (Listable item)
  // Determines if element matching item is on this list.
  {
    int holdCompare;
    boolean moreToSearch;
    ListNode location = list;
    boolean found = false;

    moreToSearch = (location != null);

    while (moreToSearch && !found) 
    {
      holdCompare = item.compareTo(location.info);
      if (holdCompare == 0)  // if they match
        found = true;
      else
      if (holdCompare < 0)   // if list element is larger than item 
        moreToSearch = false;
      else
      {
        location = location.next;
        moreToSearch = (location != null);
      }
    }

   return found;
  }

  public void insert (Listable item)
  // Adds a copy of item to list. 
  {
    ListNode newNode = new ListNode();   // reference to node being inserted
    ListNode prevLoc = new ListNode();     // trailing reference
    ListNode location = new ListNode();     // traveling reference
    boolean moreToSearch;

    location = list;
    prevLoc = null;
    moreToSearch = (location != null);

    // Find insertion point.
    while (moreToSearch)
    {
      if (item.compareTo(location.info) < 0)     // list element is larger than item
        moreToSearch = false;
      else
      {
        prevLoc = location;
        location = location.next;
        moreToSearch = (location != null);
      }
    }

    // Prepare node for insertion.
    newNode.info = (Listable)item.copy();

    // Insert node into list.
    if (prevLoc == null)                                    // Insert as first
    {
      newNode.next = list;
      list = newNode;
    }
    else
    {
      newNode.next = location;
      prevLoc.next = newNode;
    }
    numItems++;
  }

}