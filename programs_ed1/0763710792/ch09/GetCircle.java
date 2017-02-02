import java.io.*;
import ch09.circles.*;

public class GetCircle
{
  private static BufferedReader inFile;

  public static void main(String[] args) throws IOException
  {
    Circle c2 = new Circle();
    inFile = new BufferedReader(new FileReader("circle.dat"));

    c2.xValue = Integer.parseInt(inFile.readLine());
    c2.yValue = Integer.parseInt(inFile.readLine());
    c2.radius = Float.parseFloat(inFile.readLine());
    c2.solid  = Boolean.getBoolean(inFile.readLine());

    System.out.println("The xValue is " + c2.xValue);
    System.out.println("The yValue is " + c2.yValue);
    System.out.println("The radius is " + c2.radius);
    System.out.println("The solidity is " + c2.solid);

    inFile.close();
  } 
} 
