//----------------------------------------------------------------------------
// LinkedQueue.java            by Dale/Joyce/Weems                   Chapter 5
//
// Implements QueueInterface using a linked list to hold the queue items
//----------------------------------------------------------------------------

package ch05.queues;

import ch04.queues.*;

public class LinkedQueue implements QueueInterface
{

  private class QueueNode
  // Used to hold references to queue nodes for the linked queue implementation
  {
    private Object info;
    private QueueNode link;
  }

  private QueueNode front;   // reference to the front of this queue
  private QueueNode rear;    // reference to the rear of this queue

  public LinkedQueue()
  // Constructor
  {
    front = null;
    rear = null;
  }

  public void enqueue(Object item)
  // Adds item to the rear of this queue.
  { 
    QueueNode newNode = new QueueNode();
    newNode.info = item;
    newNode.link = null;
    if (rear == null)
      front = newNode;
    else
      rear.link = newNode;
    rear = newNode;
  }     

  public Object dequeue()
  // Removes front element from this queue and returns it.
  {
    Object item;

    item = front.info;
    front = front.link;
    if (front == null)
      rear = null;

    return item;
  }

  public boolean isEmpty()
  // Determines whether this queue is empty.
  {              
    if (front == null) 
      return true;
    else
      return false;
  }

  public boolean isFull()
  // Determines whether this queue is full.
  {              
      return false;
  }
}

