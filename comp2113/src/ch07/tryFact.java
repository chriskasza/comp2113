import java.io.*;

public class tryFact
{

private static int factorial(int number)
{
  if (number == 0)
    return 1;
  else
    return (number * factorial (number - 1));
}

private static int factorial2(int number)
{
  int fact = 1;
  for (int count = 2; count <= number; count++)
  {
    fact = fact * count;
  }
  return fact;
}

  public static void main(String[] args) throws IOException 
  { 
    System.out.println("5! = " + factorial(5));
    System.out.println("5! = " + factorial2(5));
  } 
}
