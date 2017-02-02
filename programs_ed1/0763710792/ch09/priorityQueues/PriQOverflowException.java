package ch09.priorityQueues;

class PriQOverflowException extends RuntimeException
{
  public PriQOverflowException()
  {
  }

  public PriQOverflowException(String message)
  {
    super(message);
  }
}