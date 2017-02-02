import java.io.*;

public class tryFact
{

private static int factorial(int n)
{
  if (n == 0)
    return 1;
  else
    return (n * factorial (n - 1));
}

private static int factorial2(int n)
{
  int fact = 1;
  for (int count = 2; count <= n; count++)
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
