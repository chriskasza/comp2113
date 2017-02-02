//----------------------------------------------------------------------------
// TDIncDate.java             by Dale/Joyce/Weems                    Chapter 1
//
// Test Driver for the IncDate class
//----------------------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import IncDate.*;

public class TDIncDate
{
  public static void main(String[] args) throws IOException 
  { 
    String testName  = "IncDate";
    String command   = null;
    int numCommands  = 0;
    IncDate  theDate = new IncDate(0,0,0);
    int month, day, year;

    //Get file name arguments from command line as entered by user
    String dataFileName = args[0];
    String outFileName  = args[1];

    //Prepare files
    BufferedReader dataFile = new BufferedReader(new FileReader(dataFileName));
    PrintWriter outFile     = new PrintWriter(new FileWriter(outFileName));

    //Get test file header line and echo print to outFile
    String testInfo = dataFile.readLine(); 
    outFile.println("Results " + testInfo);
    outFile.println();
    command = dataFile.readLine();

    //Process commands
    while(!command.equals("quit")) 
    {
      if (command.equals("IncDate"))
      {
        month  = Integer.parseInt(dataFile.readLine());
        day    = Integer.parseInt(dataFile.readLine());
        year   = Integer.parseInt(dataFile.readLine());
        outFile.println("Constructor invoked with " + month + " " + day + " " + year);
        theDate = new IncDate(month, day, year);
      }
      else if (command.equals("yearIs"))
      
      {
        outFile.println("Year is " + theDate.yearIs());
      }
      else if (command.equals("monthIs"))
      
      {
        outFile.println("Month is " + theDate.monthIs());
      }
      else if (command.equals("dayIs"))
      
      {
        outFile.println("Day is " + theDate.dayIs());
      }
      else if (command.equals("increment"))
      
      {
        theDate.increment();
        outFile.println("increment invoked ");
      }

      outFile.println("theDate: " + theDate);
      numCommands++;
      command = dataFile.readLine();
    } 

    //Close files
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
