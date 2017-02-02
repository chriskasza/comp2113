package ch04.genericLists;

// Partial listing of ListCircle class - to test Listable interface

public class ListCircle implements Listable
{
  private int xValue;      // horizontal position of center
  private int yValue;      // vertical position of center
  private float radius;
  private boolean solid;   // true means circle filled

  // code for Constructors goes here
  public ListCircle(int x, int y, float r, boolean s)
  {
    this.xValue = x;
    this.yValue = y;
    this.radius = r;
    this.solid = s;
  }

  public int compareTo(Listable otherCircle)
  {
    ListCircle other = (ListCircle)otherCircle;
    return (int)(this.radius - other.radius);
  }

  public Listable copy()
  {
    ListCircle result = new ListCircle(this.xValue, this.yValue, this.radius, this.solid);
    return result;
  }

  // more ListCircle methods as needed

} // class ListCircle
