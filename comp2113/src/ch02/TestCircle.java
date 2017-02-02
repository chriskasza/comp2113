public class TestCircle
{

  static class Circle
  {
    int xValue;      // horizontal position of center
    int yValue;      // vertical position of center
    float radius;    
    boolean solid;   // true means circle filled
  } // class Circle

  public static void main(String[] args)
  {
    Circle c1 = new Circle();
    c1.xValue = 5;
    c1.yValue = 3;
    c1.radius = 3.5f;
    c1.solid = true;

    System.out.println("c1:   " + c1);
    System.out.println("c1 x: " + c1.xValue);
  } 
} 
