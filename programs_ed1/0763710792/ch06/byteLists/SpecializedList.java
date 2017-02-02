//----------------------------------------------------------------------------
// SpecializedList.java          by Dale/Joyce/Weems                 Chapter 6
//
// Implements the specialized list ADT using a doubly linked list of nodes
//----------------------------------------------------------------------------

package ch06.byteLists;

public class SpecializedList implements SpecializedListInterface

{
  protected class SListNode
  // list nodes for the specialized list implementation
  {
    protected byte info;        // the info in a list node
    protected SListNode next;   // a link to the next node on the list
    protected SListNode back;   // a link to the next node on the list
  }

  protected SListNode listFirst;      // reference to the first node on the list
  protected SListNode listLast;       // reference to the last node on the list
  protected int numItems;             // Number of elements in the list
  protected SListNode currentFPos;    // Current forward position for iteration
  protected SListNode currentBPos;    // Current backward position for iteration

  public SpecializedList()
  // Creates an empty list object.
  {
    numItems = 0;
    listFirst = null;
    listLast = null;
    currentFPos = null;
    currentBPos = null;
  }

  public int lengthIs()
  // Determines the number of elements on this list.
  {
    return numItems;
  }

  public void resetForward()
  // Initializes current forward position for an iteration through this list. 
  {
    currentFPos = listFirst;
  }

  public byte getNextItem ()
  // Returns the value of the next element in list in forward iteration. 
  {
    byte nextItemInfo = currentFPos.info;
    if (currentFPos == listLast)
      currentFPos = listFirst;
    else 
      currentFPos = currentFPos.next;

    return nextItemInfo;
  }

  public void resetBackward()
  // Initializes current backward position for an iteration through this list. 
  {
    currentBPos = listLast;
  }

  public byte getPriorItem ()
  // Returns the value of the next element in list in backward iteration. 
  {
    byte nextItemInfo = currentBPos.info;
    if (currentBPos == listFirst)
      currentBPos = listLast;
    else 
      currentBPos = currentBPos.back;

    return nextItemInfo;
  }

  public void insertFront (byte item)
  // Adds the value of item to the front of this list.
  {
    SListNode newNode = new SListNode();   // reference to node being inserted
    newNode.info = item;
    newNode.next = listFirst;
    newNode.back = null;
    if (listFirst == null)            // inserting into an empty list
    {
      listFirst = newNode;
      listLast = newNode;
    }
    else                             // inserting into a non-empty list
    {
      listFirst.back = newNode;
      listFirst = newNode;
    }
    numItems++;
  }

  public void insertEnd (byte item)
  // Adds the value of item to the end of this list.
  {
    SListNode newNode = new SListNode();   // reference to node being inserted
    newNode.info = item;
    newNode.next = null;
    newNode.back = listLast;
    if (listFirst == null)            // inserting into an empty list
    {
      listFirst = newNode;
      listLast = newNode;
    }
    else                             // inserting into a non-empty list
    {
      listLast.next = newNode;
      listLast = newNode;
    }
    numItems++;
  }

}




