public interface FigureGeometry
{
  public static final float Pi = 3.14;

  public abstract float perimeter();
  // returns perimeter of current object

  public abstract float area();
  // returns area of current object

  public abstract int weight(int scale);
  // returns weight of current object
} 
