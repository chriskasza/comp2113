//----------------------------------------------------------------------------
// SortedLinkedList2.java          by Dale/Joyce/Weems               Chapter 7
//
// Completes the definition of a link-based list under the assumption
// that the list is kept sorted.
// Includes a recursive method for printing the list backwards.
// Uses the recursive version of the insert method.
//----------------------------------------------------------------------------

package ch07.genericLists;

import ch04.genericLists.*;
import ch04.stacks.*;

public class SortedLinkedList2 extends LinkedList
{
  public SortedLinkedList2()
  // Instantiates an empty list object.
  {
    super();
  }

  public void revPrint()
  // Prints this list in reverse order
  {
    ArrayStack stack = new ArrayStack();
    ListNode listRef;
 
    listRef = list;
 
    while (listRef != null)   // Put references onto the stack
    {
      stack.push(listRef);
      listRef = listRef.next;
    }

    // Retrieve references in reverse order and print elements
    while (!stack.isEmpty())
    {
      listRef = (ListNode)stack.top();
      stack.pop();
      System.out.println(" " + listRef.info);
    }
  }

  private void revPrint(ListNode listRef)
  {
    if (listRef != null)
    {
      revPrint(listRef.next);
      System.out.println(" " + listRef.info);
    }
  }

  public void printReversed()
  {
    revPrint(list);
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

  private ListNode recursiveInsert(ListNode subList, Listable item)
  {
    if (subList == null || item.compareTo(subList.info) < 0)
    {
      // insert new node at the front of this sub list
      ListNode newNode = new ListNode();
      newNode.info = item;
      newNode.next = subList;

      // return reference to new node
      return newNode;
    }
    else
    {
      // recursively insert item into list referenced by next
      // field of current sub list
      subList.next = recursiveInsert(subList.next, item);

      // return reference to this sub list
      return subList;
    }
  }

  public void insert(Listable item)
  // Adds a copy of item to list. 
  {
    list = recursiveInsert(list, item);
  }

}