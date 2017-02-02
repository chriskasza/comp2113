//----------------------------------------------------------------------------
// Sorts2.java              by Dale/Joyce/Weems                     Chapter 10
//
// Test harness used to run sorting algorithms that use Comparator.
//----------------------------------------------------------------------------

import java.util.*;
import java.text.DecimalFormat;
import ch10.circles.*;

public class Sorts2
{
  static final int SIZE = 6;                           // size of array to be sorted
  static SortCircle[] values = new SortCircle[SIZE];   // values to be sorted

  static void initValues()
  // Initializes the values array with random circles.
  {
    Random rand = new Random();
    for (int index = 0; index < SIZE; index++)
    {
      values[index] = new SortCircle();
      values[index].xValue = Math.abs(rand.nextInt()) % 100;
      values[index].yValue = Math.abs(rand.nextInt()) % 100;
      values[index].radius = Math.abs(rand.nextInt()) % 100;
      values[index].solid = ((Math.abs(rand.nextInt()) % 2) == 0);
    }
  }

  static public void swap(int index1, int index2)
  // Swaps the SortCircles at locations index1 and index2 of array values. 
  {
    SortCircle temp = values[index1];
    values[index1] = values[index2];
    values[index2] = temp;
  }

  static public void printValues()
  // Prints all the values integers.
  {
    SortCircle value;
    DecimalFormat fmt = new DecimalFormat("00");
    System.out.println("The values array is:");
    System.out.println();
    System.out.println(" x  y  r solid");
    System.out.println("-- -- -- -----");
    for (int index = 0; index < SIZE; index++)
    {
      value = values[index];
      System.out.print(fmt.format(value.xValue) + " ");
      System.out.print(fmt.format(value.yValue) + " ");
      System.out.print(fmt.format(value.radius) + " ");
      System.out.print(value.solid);
      System.out.println();
    }
    System.out.println();
  }

  static int minIndex(int startIndex, int endIndex, Comparator<SortCircle> comp)
  // Returns the index of the smallest value in
  // values[startIndex]..values[endIndex]
  // based on the Comparator comp.
  {
    int indexOfMin = startIndex;
    for (int index = startIndex + 1; index <= endIndex; index++)
      if (comp.compare(values[index],values[indexOfMin]) < 0)
        indexOfMin = index;
    return indexOfMin;
  }

  static void selectionSort(Comparator<SortCircle> comp)
  // Sorts the values array using the selection sort algorithm.
  {
    int endIndex = SIZE - 1;
    for (int current = 0; current < endIndex; current++)
      swap(current, minIndex(current, endIndex, comp));
  }

  public static void main(String[] args)
  {
    Comparator<SortCircle> xComp = new Comparator<SortCircle>() 
    {
      public int compare(SortCircle a, SortCircle b) 
      {
        return (a.xValue - b.xValue);
      }
    };

    Comparator<SortCircle> yComp = new Comparator<SortCircle>() 
    {
      public int compare(SortCircle a, SortCircle b) 
      {
        return (a.yValue - b.yValue);
      }
    };

    initValues();
    printValues();
    selectionSort(xComp);
    printValues();
    selectionSort(yComp);
    printValues();
  }
}
