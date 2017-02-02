import java.io.*;
import ch09.circles.*;

public class SaveCircle
{
  private static PrintWriter outFile;

  public static void main(String[] args) throws IOException
  {
    Circle c1 = new Circle();
    c1.xValue = 5;
    c1.yValue = 3;
    c1.radius = 3.5f;
    c1.solid = true;

    outFile = new PrintWriter(new FileWriter("circle.dat"));

    outFile.println(c1.xValue);
    outFile.println(c1.yValue);
    outFile.println(c1.radius);
    outFile.println(c1.solid);

    outFile.close();
  } 
} 
