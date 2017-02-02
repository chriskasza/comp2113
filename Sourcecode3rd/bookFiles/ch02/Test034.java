//----------------------------------------------------------------------------
// Test034.java              by Dale/Joyce/Weems                     Chapter 2
//
// Batch test case example
//----------------------------------------------------------------------------

import ch02.stringLogs.*;

public class Test034
{
  public static void main(String[] args)
  { 
    ArrayStringLog test = new ArrayStringLog("Test 34");
    test.insert("trouble in the fields");
    test.insert("love at the five and dime");
    test.insert("once in a very blue moon");
    if (test.contains("Love at the Five and Dime"))
      System.out.println("Test 34 passed");
    else
      System.out.println("Test 34 failed");
  }
}