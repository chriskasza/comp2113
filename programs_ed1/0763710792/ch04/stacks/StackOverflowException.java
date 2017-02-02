package ch04.stacks;

public class StackOverflowException extends RuntimeException
{
  public StackOverflowException()
  {
  }

  public StackOverflowException(String message)
  {
    super(message);
  }
}