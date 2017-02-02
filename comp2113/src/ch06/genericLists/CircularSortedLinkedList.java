//----------------------------------------------------------------------------
// CircularSortedLinkedList.java      by Dale/Joyce/Weems            Chapter 6
//
// Completes the definition of an link-based list under the assumption
// that the list is circular and is kept sorted.
//----------------------------------------------------------------------------

package ch06.genericLists;

import ch04.genericLists.*;

public class CircularSortedLinkedList extends LinkedList
{
  public CircularSortedLinkedList()
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
      holdCompare = item.compareTo(location.next.info);
      if (holdCompare == 0)  // if they match
        found = true;
      else
      if (holdCompare < 0)   // if list element is larger than item 
        moreToSearch = false;
      else
      {
        location = location.next;
        moreToSearch = (location != list);
      }
    }

   return found;
  }

  public void insert (Listable item)
  // Adds a copy of item to list. 
  {
    ListNode newNode = new ListNode();     // reference to node being inserted
    newNode.info = (Listable)item.copy();    // set info attribute of new node 

    if (list == null)      // insert into an empty list
    {
      list = newNode;
      newNode.next = newNode;
    }
    else                   // insert into a non-empty list
    {
      ListNode prevLoc = new ListNode();     // create trailing reference
      ListNode location = new ListNode();    // create traveling reference
      boolean moreToSearch = true;

      location = list.next;
      prevLoc = list;

      // Find insertion point.
      while (moreToSearch)
      {
        if (item.compareTo(location.info) < 0)     // list element is larger than item
          moreToSearch = false;
        else
        {
          prevLoc = location;
          location = location.next;
          moreToSearch = (location != list.next);
        }
      }

      // Insert node into list.
      newNode.next = location;
      prevLoc.next = newNode;
      if (item.compareTo(list.info) > 0)          // new item is last on this list
        list = newNode;
    }
    numItems++;
  }

  public void delete (Listable item)
  // Deletes the element of this list whose key matches item’s key.
  {
    ListNode location = list;

    if (location == location.next)   // single element list
      list = null;
    else
      {
      while (item.compareTo(location.next.info) != 0)
        location = location.next;
      if (location.next == list)         // deleting last element
        list = location;
      // Delete node at location.next.
      location.next = location.next.next;
      }
    numItems--;
  }

  public void reset()
  // Initializes current position for an iteration through this list. 
  {
    if (list == null)
      currentPos  = list;
    else
      currentPos = list.next;
  }

  public Listable getNextItem ()
  // Returns copy of the next element in list. 
  {
    Listable nextItemInfo = currentPos.info.copy();
    currentPos = currentPos.next;

    return nextItemInfo;
  }
}