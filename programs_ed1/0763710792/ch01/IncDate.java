public class IncDate extends Date
{
  public IncDate(int newMonth, int newDay, int newYear)
  {
    super(newMonth, newDay, newYear);
   }

  public void increment()
  {
    // increment algorithm goes here
    // it updates the year, month, and day attributes
    day = day + 1;
  }
}
