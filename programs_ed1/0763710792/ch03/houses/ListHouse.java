//----------------------------------------------------------------------------
// ListHouse.java             by Dale/Joyce/Weems                    Chapter 3
//
// Provides elements for a list of house information.
//----------------------------------------------------------------------------

package ch03.houses;

import ch03.genericLists.*;

public class ListHouse implements Listable
{
  // house information
  private String lastName;
  private String firstName;
  private int lotNumber;
  private int price;
  private int squareFeet;
  private int bedRooms;

  public ListHouse(String lastName, String firstName, int lotNumber, 
                   int price, int squareFeet, int bedRooms )
  {
    this.lastName  = lastName;
    this.firstName  = firstName;
    this.lotNumber  = lotNumber;
    this.price = price;
    this.squareFeet = squareFeet;
    this.bedRooms = bedRooms;
  }

  public Listable copy()
  // returns a copy of this ListHouse
  {
    ListHouse result = new ListHouse(lastName, firstName, lotNumber, price, squareFeet, bedRooms);
    return result;
  }

  public int compareTo(Listable otherListHouse)
  // houses are compared  based on their lot numbers
  {
   ListHouse other = (ListHouse)otherListHouse;
   return (this.lotNumber - other.lotNumber);
  }

  //observers
  public String lastName()
  {
    return lastName;
  }

  public String firstName()
  {
    return firstName;
  }

  public int lotNumber()
  {
    return lotNumber;
  }

  public int price()
  {
    return price;
  }

  public int squareFeet()
  {
    return squareFeet;
  }

  public int bedRooms()
  {
    return bedRooms;
  }
}

