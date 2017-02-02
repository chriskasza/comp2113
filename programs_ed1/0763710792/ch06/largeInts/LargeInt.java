//----------------------------------------------------------------------------
// LargeInt.java             by Dale/Joyce/Weems                     Chapter 6
//
// Provides a Large Integer ADT. Large Integers can consist of any number
// of digits, plus a sign. Supports an add and a subtract operation.
//----------------------------------------------------------------------------

package ch06.largeInts;

import ch06.byteLists.*;

public class LargeInt
{
  private SpecializedList numbers;    // holds digits
  
  // constants for sign variable
  private static final boolean PLUS = true;
  private static final boolean MINUS = false;

  private boolean sign;               

  public LargeInt()                   
  {
    numbers = new SpecializedList();
    sign = PLUS;                     
  }

  public void setNegative()
  {
    sign = MINUS;
  }

  public void addDigit(byte digit)
  {
    numbers.insertEnd(digit);
  }

  private static boolean greaterList(SpecializedList first, SpecializedList second)
  // Effect: returns true if first represents a larger number than second,
  //         otherwise returns false;
  // Precondition: no leading zeros
  {
    boolean greater = false;
    if (first.lengthIs() > second.lengthIs())
      greater = true;
    else 
    if (first.lengthIs() < second.lengthIs())
      greater = false;
    else
    {
      byte digitFirst;
      byte digitSecond;
      first.resetForward();
      second.resetForward();

      // set up loop
      int length = first.lengthIs();
      boolean keepChecking = true;
      int count = 1;

      while ((count <= length) && (keepChecking))
      {
        digitFirst = first.getNextItem();
        digitSecond = second.getNextItem();
        if (digitFirst > digitSecond)
        {
          greater = true;
          keepChecking = false;
        }
        else
        if (digitFirst < digitSecond)
        {
          greater = false;
          keepChecking = false;
        }
        count++;
      }
    }
    return greater;
  }

  private static SpecializedList addLists(SpecializedList larger, SpecializedList smaller)
  // Returns a specialized list that is a byte-by-byte sum of the two argument lists
  // Assumes larger >= smaller
  {
    byte digit1;
    byte digit2;
    byte temp;
    byte carry = 0;

    int largerLength = larger.lengthIs();
    int smallerLength = smaller.lengthIs();
    int lengthDiff;

    SpecializedList result = new SpecializedList();

    larger.resetBackward();
    smaller.resetBackward();

    // process both lists while both have digits
    for (int count = 1; count <= smallerLength; count++)
    {
      digit1 = larger.getPriorItem();     
      digit2 = smaller.getPriorItem();  
      temp = (byte)(digit1 + digit2 + carry);
      carry = (byte)(temp / 10);
      result.insertFront((byte)(temp % 10));
    }

    // finish processing of leftover digits
    lengthDiff = (largerLength - smallerLength);
    for (int count = 1; count <= lengthDiff; count++)
    {
      digit1 = larger.getPriorItem();  
      temp = (byte)(digit1 + carry);
      carry = (byte)(temp / 10);
      result.insertFront((byte)(temp % 10));
    }

    if (carry != 0)
      result.insertFront((byte)carry);   

    return result;
  }

  private static SpecializedList subtractLists(SpecializedList larger, SpecializedList smaller)
  // Returns a specialized list that is the difference of the two argument lists
  // Assumes larger >= smaller
  {
    byte digit1;
    byte digit2;
    byte temp;
    boolean borrow = false;

    int largerLength = larger.lengthIs();
    int smallerLength = smaller.lengthIs();
    int lengthDiff;

    SpecializedList result = new SpecializedList();

    larger.resetBackward();
    smaller.resetBackward();

    // process both lists while both have digits
    for (int count = 1; count <= smallerLength; count++)
    {
      digit1 = larger.getPriorItem();     
      if (borrow)
      {
        if (digit1 != 0)
        {
          digit1 = (byte)(digit1 - 1);
          borrow = false;
        }
        else
        {
          digit1 = 9;
          borrow = true;
        }
      }

      digit2 = smaller.getPriorItem();  

      if (digit2 <= digit1)
        result.insertFront((byte)(digit1 - digit2));
      else
      {
        borrow = true;
        result.insertFront((byte)(digit1 + 10 - digit2));
      }
    }      

    // finish processing of leftover digits
    lengthDiff = (largerLength - smallerLength);
    for (int count = 1; count <= lengthDiff; count++)
    {
      digit1 = larger.getPriorItem();  
      if (borrow)
      {
        if (digit1 != 0)
        {
          digit1 = (byte)(digit1 - 1);
          borrow = false;
        }
        else
        {
          digit1 = 9;
          borrow = true;
        }
      }
      result.insertFront(digit1);
    }

    return result;
  }

  public static LargeInt add(LargeInt first, LargeInt second)
  // Returns a LargeInt that is the sum of the two argument LargeInts
  {
    LargeInt sum = new LargeInt();

    if (first.sign == second.sign)
    {
      if (greaterList(first.numbers, second.numbers))
        sum.numbers = addLists(first.numbers, second.numbers);
      else
        sum.numbers = addLists(second.numbers, first.numbers);
      sum.sign = first.sign;
    }
    else   // signs are different 
    {
      if (greaterList(first.numbers, second.numbers))
      {
        sum.numbers = subtractLists(first.numbers, second.numbers);
        sum.sign = first.sign;
      }
      else
      {
        sum.numbers = subtractLists(second.numbers, first.numbers);
        sum.sign = second.sign;
      }
    }

    return sum;
  }

  public static LargeInt subtract(LargeInt first, LargeInt second)
  // Returns a LargeInt that is the difference of the two argument LargeInts
  {
    LargeInt diff = new LargeInt();

    // create an inverse of second
    LargeInt negSecond = new LargeInt();
    negSecond.sign = !second.sign;
    second.numbers.resetForward();
    int length = second.numbers.lengthIs();
    for (int count = 1; count <= length; count++)
      negSecond.numbers.insertEnd(second.numbers.getNextItem());
    
    diff = add(first, negSecond);

    return diff;
  }

  public String toString()
  {
    String largeIntString;
    if (sign == PLUS)
      largeIntString = "+";
    else
      largeIntString = "-";
   
    int length;
    length = numbers.lengthIs();
    numbers.resetForward();
    for (int count = length; count >= 1; count--)
    {
      largeIntString = largeIntString + numbers.getNextItem();
      if ((((count - 1) % 3) == 0) && (count != 1))
       largeIntString = largeIntString + ",";
    }
    return(largeIntString);
  }
}
