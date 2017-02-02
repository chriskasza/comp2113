//----------------------------------------------------------------------------
// SortedStringList.java         by Dale/Joyce/Weems                 Chapter 3
//
// Completes the definition of the StringList class under the assumption
// that the list is kept sorted.
//----------------------------------------------------------------------------

package ch03.stringLists;

public class SortedStringList extends StringList 
{
  public SortedStringList(int maxItems)
  // Instantiates and returns a reference to an empty list object with room for maxItems elements.
  {
    super(maxItems);
  }

  public SortedStringList()
  // Instantiates and returns a reference to an empty list object with room for 100 elements.
  {
    super(100);
  }

  public boolean isThere (String item)
  // Returns true if item is on this list, otherwise returns false.
  {
    int compareResult;
    int midPoint;
    int first = 0;
    int last = numItems - 1;
    boolean moreToSearch = (first <= last);
    boolean found = false;

    while (moreToSearch && !found) 
    {
      midPoint = (first + last) / 2;
      compareResult = item.compareTo(list[midPoint]);

      if (compareResult == 0)
        found = true;
      else if (compareResult < 0)      // item is less than element at location
      {
        last = midPoint - 1;
        moreToSearch = (first <= last);
      }
      else                           // item is greater than element at location
      {
        first = midPoint + 1;
        moreToSearch = (first <= last);
      }
    }

   return found;
  }

  public void insert (String item)
  // Adds a copy of item to this list. 
  {
    int location = 0;
    boolean moreToSearch = (location < numItems);

    while (moreToSearch) 
    {
      if (item.compareTo(list[location]) < 0)  // item is less
        moreToSearch = false;
      else                                     // item is more
      {
        location++;
        moreToSearch = (location < numItems);
      }
    }

    for (int index = numItems; index > location; index--)
      list[index] = list[index - 1];

    list[location] = new String(item);
    numItems++;
  }

  public void delete (String item)
  // Deletes the element from this list that matches item. 
  {
    int location = 0;

    while (item.compareTo(list[location]) != 0)
      location++;

    for (int index = location + 1; index < numItems; index++)
      list[index - 1] = list[index];

    numItems--;
  }
}
