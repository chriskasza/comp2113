package ch04.stacks;

public class StackUnderflowException extends RuntimeException
{
  public StackUnderflowException()
  {
  }

  public StackUnderflowException(String message)
  {
    super(message);
  }
}