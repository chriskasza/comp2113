//----------------------------------------------------------------------------
// TDSortedList.java           by Dale/Joyce/Weems                   Chapter 3
//
// Test Driver for the SortedList class
//----------------------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import ch03.genericLists.*;

public class TDSortedList
{
  private static Frame outputDisplay;
  private static String testName = "SortedList";

  public static void main(String[] args) throws IOException 
  {
    String command = null;
    int numCommands = 0;

    BufferedReader dataFile = new BufferedReader(new FileReader(args[0]));
    PrintWriter outFile = new PrintWriter(new FileWriter(args[1]));

    SortedList list;
    int size;
    ListString aString, bString;
  
    list = new SortedList();
    
    String testInfo = dataFile.readLine();
    outFile.println("Results " + testInfo);
    outFile.println();

    command = dataFile.readLine();

    while(!command.equals("quit"))
    {

      if (command.equals("SortedList1"))
      {
        size = Integer.parseInt(dataFile.readLine());
        list = new SortedList(size);;
        outFile.println("The list is instantiated with size " + size);
      }
      else 
      if (command.equals("SortedList2"))
      {
        list = new SortedList();;
        outFile.println("The list is instantiated with default size");
      }
      else 
      if (command.equals("isFull"))
      {
        outFile.println("The list is full is " + list.isFull());
      }
      else 
      if (command.equals("lengthIs"))
      {
        outFile.println("Length of the list is " + list.lengthIs());
      }
      else 
      if (command.equals("isThere"))
      {
        aString = new ListString(dataFile.readLine());
        outFile.println(aString + " is on the list: " + list.isThere(aString));
      }
      else 
      if (command.equals("retrieve"))
      {
        aString = new ListString(dataFile.readLine());
        bString = (ListString)list.retrieve(aString);
        outFile.println(bString + " was retrieved from the list");
      }
      else 
      if (command.equals("insert"))
      {
        aString = new ListString(dataFile.readLine());
        list.insert(aString);
        outFile.println(aString + " was inserted into the list");
      }
      else 
      if (command.equals("delete"))
      {
        aString = new ListString(dataFile.readLine());
        list.delete(aString);
        outFile.println(aString + " was deleted from the list");
      }
      else 
      if (command.equals("reset"))
      {
        list.reset();
        outFile.println("reset invoked");
      }
      else 
      if (command.equals("getNextItem"))
      {
        aString = (ListString) list.getNextItem();
        outFile.println("the next list item is " + aString);
      }

      numCommands++;
      command = dataFile.readLine();
    }

    dataFile.close();
    outFile.close();

    //Set up output frame
    JFrame outputFrame = new JFrame();
    outputFrame.setTitle("Testing " + testName);
    outputFrame.setSize(300,100);
    outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    // Instantiate content pane and information panel
    Container contentPane = outputFrame.getContentPane();
    JPanel infoPanel      = new JPanel();

    // set layout
    infoPanel.setLayout(new GridLayout(2,1));

    // create labels
    JLabel countInfo = new JLabel(numCommands + " commands completed.  ");
    JLabel finishedInfo = new JLabel("Testing completed. Close window to exit program.");

    // add information
    infoPanel.add(countInfo);
    infoPanel.add(finishedInfo);
    contentPane.add(infoPanel);

    // show information
    outputFrame.show();
  } 
} 