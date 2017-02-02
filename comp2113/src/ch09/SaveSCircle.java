import java.io.*;
import ch09.circles.*;

public class SaveSCircle
{
  public static void main(String[] args) throws IOException
  {
    SCircle c1 = new SCircle();
    c1.xValue = 5;
    c1.yValue = 3;
    c1.radius = 3.5f;
    c1.solid = true;

    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.dat"));

    out.writeObject(c1);
    out.close();
  } 
} 
