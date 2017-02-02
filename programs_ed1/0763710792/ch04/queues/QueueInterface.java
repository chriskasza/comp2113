//----------------------------------------------------------------------------
// QueueInterface.java           by Dale/Joyce/Weems                 Chapter 4
//
// Interface for a class that implements a queue of Objects.
// A queue is a first-in, first-out structure.
//----------------------------------------------------------------------------

package ch04.queues;

public interface QueueInterface

{
  public void enqueue(Object item); 
  // Effect:         Adds item to the rear of this queue.
  // Precondition:   This queue is not full.
  // Postcondition:  item is at the rear of this queue.

  public Object dequeue();
  // Effect:         Removes front element from this queue and returns it.
  // Precondition:   This queue is not empty.
  // Postconditions: Front element has been removed from this queue.
  //                 Return value = (the removed element)

  public boolean isEmpty();
  // Effect:         Determines whether this queue is empty.
  // Postcondition:  Return value = (this queue is empty)

  public boolean isFull();
  // Effect:         Determines whether this queue is full.
  // Postcondition:  Return value = (queue is full)
}





