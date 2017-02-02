//----------------------------------------------------------------------------
// Heap.java                by Dale/Joyce/Weems                      Chapter 9
//
// Defines all constructs for a heap of Comparable objects.
// The dequeue method returns the largest value in the heap.
//----------------------------------------------------------------------------

package ch09.priorityQueues;

public class Heap implements PriQueueInterface
{
  private Comparable[] elements;  // Array that holds priority queue elements
  private int lastIndex;          // index of last element in priority queue
  private int maxIndex;           // index of last position in array

  // Constructor
  public Heap(int maxSize)
  {
    elements = new Comparable[maxSize];
    lastIndex = -1;
    maxIndex = maxSize - 1;
  }

  public boolean isEmpty()
  // Determines whether this priority queue is empty.
  {
    return (lastIndex == -1);
  }

  public boolean isFull()
  // Determines whether this priority queue is full.
  {
    return (lastIndex == maxIndex);
  }

  private void reheapUp(Comparable item)
  // Current lastIndex position is empty
  // Inserts item into the tree and ensures shape and order properties
  {
    int hole = lastIndex;
    while ((hole > 0)                                       // hole is not root
           &&                                               // short circuit
           (item.compareTo(elements[(hole - 1) / 2]) > 0))  // item > hole's parent
    {
      elements[hole] = elements[(hole - 1) / 2];            // move hole's parent down
      hole = (hole - 1) / 2;                                // move hole up
    }

    elements[hole] = item;                        // place item into final hole
  }

  public void enqueue(Comparable item) throws PriQOverflowException
  // Adds item to this priority queue.
  // Throws PriQOverflowException if priority queue already full
  {
    if (lastIndex == maxIndex)
      throw new PriQOverflowException("Priority queue is full");
    else
    {
      lastIndex = lastIndex + 1;
      reheapUp(item);
    }
  }

  private int newHole(int hole, Comparable item)
  // If either child of hole is larger than item this returns the index
  // of the larger child; otherwise it returns the index of hole
  {
    int left = (hole * 2) + 1;
    int right = (hole * 2) + 2;

    if (left > lastIndex)
      // hole has no children
      return hole;         
    else
    if (left == lastIndex)
      // hole has left child only
      if (item.compareTo(elements[left]) < 0)             
        // item < left child
        return left;
      else
        // item >= left child
        return hole;
    else
    // hole has two children 
    if (elements[left].compareTo(elements[right]) < 0)
      // left child < right child
      if (elements[right].compareTo(item) <= 0)
        // right child <= item
        return hole;
      else
        // item < right child
        return right;
    else
    // left child >= right child
    if (elements[left].compareTo(item) <= 0)
      // left child <= item
      return hole;
    else
      // item < left child
      return left;
  }

  private void reheapDown(Comparable item)
  // Current root position is "empty";
  // Inserts item into the tree and ensures shape and order properties
  {
    int hole = 0;      // current index of hole
    int newhole;       // index where hole should move to

    newhole = newHole(hole, item);   // find next hole
    while (newhole != hole)
    {
      elements[hole] = elements[newhole];  // move element up
      hole = newhole;                      // move hole down
      newhole = newHole(hole, item);       // find next hole
    }
    elements[hole] = item;           // fill in the final hole
  }

  public Comparable dequeue() throws PriQUnderflowException
  // Removes element with highest priotity from this priority queue 
  // and returns a reference to it.
  // Throws PriQUnderflowException if priority queue is empty.
  {
    Comparable hold;      // item to be dequeued and returned
    Comparable toMove;    // item to move down heap

    if (lastIndex == -1)
      throw new PriQUnderflowException("Priority queue is empty");
    else
    {
      hold = elements[0];            // remember item to be returned
      toMove = elements[lastIndex];  // item to reheap down
      lastIndex = lastIndex - 1;     // decrease priority queue size
      reheapDown(toMove);            // rstore heap properties
      return hold;                   // return largest element
    }
  }

  public String toString()
  // returns a string of all the heap elements
  {
    String theHeap = new String("the heap is:\n");
    for (int index = 0; index <= lastIndex; index++)
      theHeap = theHeap + index + ". " + elements[index] + "\n";
    return theHeap;
  }
}
