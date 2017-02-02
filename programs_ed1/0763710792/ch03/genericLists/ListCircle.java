package ch03.genericLists;

// Partial listing of ListCircle class - to test Listable interface

public class ListCircle implements Listable
{
  private int xvalue;      // horizontal position of center
  private int yvalue;      // vertical position of center
  private float radius;
  private boolean solid;   // true means circle filled

  // code for Constructors goes here
  public ListCircle(int x, int y, float r, boolean s)
  {
    this.xvalue = x;
    this.yvalue = y;
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
    ListCircle result = new ListCircle(this.xvalue, this.yvalue, this.radius, this.solid);
    return result;
  }

  // more ListCircle methods as needed

} // class ListCircle
