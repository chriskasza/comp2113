//----------------------------------------------------------------------------
// UnsortedStringList2.java        by Dale/Joyce/Weems               Chapter 3
//
// Completes the definition of the StringList class under the assumption
// that the list is not kept sorted.
//----------------------------------------------------------------------------

package ch03.stringLists;

public class UnsortedStringList2 extends StringList 
{
  public UnsortedStringList2(int maxItems)
  // Instantiates and returns a reference to an empty list object with room for maxItems elements.
  {
    super(maxItems);
  }

  public UnsortedStringList2()
  // Instantiates and returns a reference to an empty list object with room for 100 elements.
  {
    super(100);
  }

  public boolean isThere (String item)
  // Returns true if item is on this list, otherwise returns false.
  {
    boolean moreToSearch;
    int location = 0;
    boolean found = false;

    moreToSearch = (location < numItems);

    while (moreToSearch && !found) 
    {
      if (item.compareTo(list[location]) == 0)  // if they match
        found = true;
      else
      {
        location++;
        moreToSearch = (location < numItems);
      }
    }

   return found;
  }

  public void insert (String item)
  // Adds a copy of item to this list. 
  {
    list[numItems] = new String(item);
    numItems++;
  }

  public void delete (String item)
  // Deletes the element that matches item from this list. 
  {
    int location = 0;

    while (item.compareTo(list[location]) != 0)
      location++;

    list[location] = list[numItems - 1];
    numItems--;
  }

}
