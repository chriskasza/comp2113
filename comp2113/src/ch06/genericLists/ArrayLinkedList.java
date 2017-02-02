//----------------------------------------------------------------------------
// ArrayLinkedList.java          by Dale/Joyce/Weems                 Chapter 6
//
// Implements an array-based sorted linked list of Listable elements.
//----------------------------------------------------------------------------

package ch06.genericLists;

import ch04.genericLists.*;

public class ArrayLinkedList implements ListInterface
{

  private static final int NUL = -1;   // end of list symbol

  private class AListNode 
  {
    private Listable info;         // the info in a list node
    private int next;              // a link to the next node on the list
  }  

  private AListNode[] nodes;       // array of ListNode holds the linked list
  
  private int list;                // reference to the first node on the list
  private int free;                // reference to the first node on the free list

  private int numItems;            // Number of elements in the list
  private int currentPos;          // Current position for iteration

  public ArrayLinkedList(int maxItems)
  // Instantiates and returns a reference to an empty list object with
  // room for maxItems elements
  {
    nodes = new AListNode[maxItems];
    for (int index = 0; index < maxItems; index++)
      nodes[index] = new AListNode();
   
    // link together the free nodes
    for (int index = 1; index < maxItems; index++)
      nodes[index - 1].next = index;
    nodes[maxItems - 1].next = NUL;

    list = NUL;
    free = 0;
    numItems = 0;
    currentPos = NUL;
  }

  public ArrayLinkedList()
  // Instantiates and returns a reference to an empty list object with
  // room for 100 elements
  {
    nodes = new AListNode[100];
    for (int index = 0; index < 100; index++)
      nodes[index] = new AListNode();

    for (int index = 1; index < 100; index++)
      nodes[index - 1].next = index;
    nodes[99].next = NUL;
    list = NUL;
    free = 0;
    numItems = 0;
    currentPos = NUL;
  }

  private int getNode()
  // returns the index of the next available node from the free list
  // and updates the free list index
  {
    int hold;
    hold = free;
    free = nodes[free].next;
    return hold;
  }

  private void freeNode(int index)
  // frees the node at array position index by linking it into the free list
  {
    nodes[index].next = free;
    free = index;
  }

  public boolean isFull()
  // Determines whether this list is full.
  {
    return (free == NUL);
  }

  public int lengthIs()
  // Determines the number of elements on this list.
  {
    return numItems;
  }

  public boolean isThere (Listable item)
  // Determines if element matching item is on this list.
  {
    int holdCompare;
    boolean moreToSearch;
    int location = list;
    boolean found = false;

    moreToSearch = (location != NUL);

    while (moreToSearch && !found) 
    {
      holdCompare = item.compareTo(nodes[location].info);
      if (holdCompare == 0)  // if they match
        found = true;
      else
      if (holdCompare < 0)   // if list element is larger than item 
        moreToSearch = false;
      else
      {
        location = nodes[location].next;
        moreToSearch = (location != NUL);
      }
    }

   return found;
  }

  public Listable retrieve (Listable item)
  // Returns a copy of the list element with the same key as item.
  {
    int location = list;
    boolean found = false;

    while (!found)
    {
      if (item.compareTo(nodes[location].info) == 0)    // if they match
        found = true;
      else
        location = nodes[location].next;
    }

    return nodes[location].info.copy();
  } 

  public void insert (Listable item)
  // Adds a copy of item to list. 
  {
    int newNode = getNode();     // reference to node being inserted
    int prevLoc;                 // trailing reference
    int location;                // traveling reference
    boolean moreToSearch;

    location = list;
    prevLoc = NUL;
    moreToSearch = (location != NUL);

    // Find insertion point.
    while (moreToSearch)
    {
      if (item.compareTo(nodes[location].info) < 0)  // list element is larger than item
        moreToSearch = false;
      else
      {
        prevLoc = location;
        location = nodes[location].next;
        moreToSearch = (location != NUL);
      }
    }

    // Prepare node for insertion.
    nodes[newNode].info = (Listable)item.copy();

    // Insert node into list.
    if (prevLoc == NUL)                              // Insert as first
    {
      nodes[newNode].next = list;
      list = newNode;
    }
    else
    {
      nodes[newNode].next = location;
      nodes[prevLoc].next = newNode;
    }
    numItems++;
  }

  public void delete (Listable item)
  // Deletes the element of this list whose key matches item’s key.
  {
    int hold;                               // to remember deleted node index
    int location = list;

    // Locate node to be deleted.
    if (item.compareTo(nodes[location].info) == 0)
    {
      hold = list;
      list = nodes[list].next;                           // Delete first node.
    }
    else
      {
      while (item.compareTo(nodes[nodes[location].next].info) != 0)
        location = nodes[location].next;
      // Delete node at nodes[location].next.
      hold = nodes[location].next;
      nodes[location].next = nodes[nodes[location].next].next;
      }
    freeNode(hold);
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
    Listable nextItemInfo = nodes[currentPos].info.copy();
    if (nodes[currentPos].next == NUL)
      currentPos = list;
    else 
      currentPos = nodes[currentPos].next;

    return nextItemInfo;
  }

}