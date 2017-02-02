//----------------------------------------------------------------------------
// IntSetStats.java            by Dale/Joyce/Weems                   Chapter 4
//
// Keeps track of some statistics about a set of integers passed to it
//----------------------------------------------------------------------------

package ch04.postfix;

public class IntSetStats 
{
  private int count = 0;
  private int max = Integer.MIN_VALUE;
  private int min = Integer.MAX_VALUE;
  private int total = 0;

  public void register(int value)
  {      
    count = count + 1;
    if (value > max)
      max = value;
    if (value < min)
      min = value;
    total = total + value;
  }

  public String getCount()
  {
    return Integer.toString(count);
  }

  public String getMax()
  {
    return Integer.toString(max);
  }

  public String getMin()
  {
    return Integer.toString(min);
  }

  public String getAverage()
  {
    if (count != 0)
      return Integer.toString((total / count));
    else
      return "none";
  }
}
