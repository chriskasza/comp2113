//----------------------------------------------------------------------------
// ArrayQueue.java             by Dale/Joyce/Weems                   Chapter 4
//
// Implements QueueInterface using an array to hold the queue items
//----------------------------------------------------------------------------

package ch04.queues;

public class ArrayQueue implements QueueInterface 
{
  private Object[] queue;           // Array that holds queue elements
  private int capacity;             // size of the array (capacity of the queue)
  private int numItems = 0;         // number of items on the queue
  private int front = -1;           // index of front of queue
  private int rear = 0;             // index of rear of queue

  // Constructors
  public ArrayQueue() 
  {
    queue = new Object[100];
    capacity = 100;
  }

  public ArrayQueue(int maxSize) 
  {
    queue = new Object[maxSize];
    capacity = maxSize;
  }

  public void enqueue(Object item)
  // Adds an element to the front of this queue
  {      
    front = (front + 1) % capacity;
    queue[front] = item;
    numItems = numItems + 1;
  }

  public Object dequeue()
  // Removes an element from the rear of this queue
  {       
    Object toReturn = queue[rear];
    queue[rear] = null;
    rear = (rear + 1) % capacity;
    numItems = numItems - 1;
    return toReturn;
  }

  public boolean isEmpty()
  // Checks if this queue is empty
  {              
    return (numItems == 0);
  }

  public boolean isFull()
  // Checks if this queue is full
  {              
    return (numItems == capacity);
  }
}