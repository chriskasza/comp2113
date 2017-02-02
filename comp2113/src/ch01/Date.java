public class Date
{
  protected int year;
  protected int month;
  protected int day;

  public Date(int newMonth, int newDay, int newYear)
  {
    month = newMonth;
    day = newDay;
    year = newYear;
   }

  public int yearIs()
  {
    return year;
  }

  public int monthIs()
  {
    return month;
  }

  public int dayIs()
  {
    return day;
  }

  public String toString()
  {
    return(month + "/" + day + "/" + year);
  }

}
 