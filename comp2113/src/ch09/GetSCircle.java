import java.io.*;
import ch09.circles.*;

public class GetSCircle
{
  public static void main(String[] args) throws IOException
  {
    SCircle c2 = new SCircle();
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("objects.dat"));

    try
    {
      c2 = (SCircle)in.readObject();
    }
    catch (Exception e)
    {
      System.out.println("Error in readObject: " + e);
      System.exit(1);
    }

    System.out.println("The xValue is " + c2.xValue);
    System.out.println("The yValue is " + c2.yValue);
    System.out.println("The radius is " + c2.radius);
    System.out.println("The solidity is " + c2.solid);

    in.close();
  } 
} 
