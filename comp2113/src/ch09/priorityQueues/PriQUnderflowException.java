package ch09.priorityQueues;

class PriQUnderflowException extends RuntimeException
{
  public PriQUnderflowException()
  {
  }

  public PriQUnderflowException(String message)
  {
    super(message);
  }
}