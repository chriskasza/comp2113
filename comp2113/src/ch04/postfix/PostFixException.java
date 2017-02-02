package ch04.postfix;

public class PostFixException extends RuntimeException
{
  public PostFixException()
  {
  }

  public PostFixException(String message)
  {
    super(message);
  }
}