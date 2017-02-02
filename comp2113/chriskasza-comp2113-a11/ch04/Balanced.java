//----------------------------------------------------------------------------
// Balanced.java              by Dale/Joyce/Weems                    Chapter 4
//
// Checks for balanced special symbols.
// Input file consists of a sequence of expressions, one per line.
// Special symbol types (), [], and {}.
// Output file contains, for each expression:
//    A copy of the expression.
//    Whether or not the expression is balanced.
// Input and output file names are supplied by user through command line parameters.
// Output frame supplies summary statistics.
//----------------------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import ch04.stacks.*;
import java.text.DecimalFormat;

public class Balanced 
{
  public static boolean openSet(char ch)
  // returns true of ch is one of (, [, {
  {
    return (   (ch == '(')
            || (ch == '[')
            || (ch == '{'));
  }

  public static boolean closeSet(char ch)
  // returns true of ch is one of ), ], }
  {
    return (   (ch == ')')
            || (ch == ']')
            || (ch == '}'));
  }

  public static void main(String[] args) throws IOException 
  {
    int numStrings = 0;              // total number of strings processed
    int wellFormed = 0;              // number of well formed strings found
    int illFormed = 0;               // number of ill formed strings found

    char currChar;                   // current string character being studied
    int  currCharIndex;              // index of current character
    int  lastCharIndex;              // index of last character in the string

    char openSymbol;                 // open symbol character popped from stack

    boolean balancedString;          // true as long as string is balanced

    StackInterface stack;            // holds unmatched open symbols

    String line = null;              // input line
    String dataFileName = args[0];   // name of input file
    String outFileName = args[1];    // name of output file

    BufferedReader dataFile = new BufferedReader(new FileReader(dataFileName));
    PrintWriter outFile = new PrintWriter(new FileWriter(outFileName));
    DecimalFormat fmt = new DecimalFormat("00");

    line = dataFile.readLine();      // read the first input line

    while(line!=null)                // while haven't read all of the input lines
    {
      numStrings++;
      outFile.println("String " + fmt.format(numStrings) + ": " + line);
      outFile.print("           ");

      balancedString = true;
      stack = new ArrayStack();

      currCharIndex = 0;
      lastCharIndex = line.length() - 1;

      while (balancedString && (currCharIndex <= lastCharIndex))
      {
        currChar = line.charAt(currCharIndex);
        outFile.print(currChar);

        if(openSet(currChar))        // if the current character is one of [, {, (
        {
          // wrap the character and push it onto the stack
          Character openSymbolObject = new Character(currChar);
          stack.push(openSymbolObject);
        }
        else
        {
          if(closeSet(currChar))     // if the current character is one of ], }, ) 
          {
            try                      // try to pop a character off the stack
            {
              openSymbol = ((Character)stack.top()).charValue();
              stack.pop();

              // if the popped character doesn't match
              if ( !(  ((currChar == ')') && (openSymbol == '('))
                     ||((currChar == ']') && (openSymbol == '['))
                     ||((currChar == '}') && (openSymbol == '{'))))
                balancedString = false;
            } 
            catch(StackUnderflowException e)     // stack was empty
            {
              balancedString = false;
            }
          }
        }
        currCharIndex++;             // set up processing of next character
      }

      if (!balancedString)
      {
        illFormed++;
        outFile.println(" Unbalanced symbols ");
      }
      else
      if (!stack.isEmpty())
      {
        illFormed++;
        outFile.println(" Premature end of string");
      }
      else
      {
        wellFormed++;
        outFile.println(" The string is balanced.");
      }

      outFile.println();
      line = dataFile.readLine();    // set up processing of next line
    }
    dataFile.close();
    outFile.close();

    //Set up output frame
    JFrame outputFrame = new JFrame();
    outputFrame.setTitle("Balanced Parenthesis");
    outputFrame.setSize(300,200);
    outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
//    outputFrame.setDefaultCloseOperation(3);   

    // Instantiate content pane and information panel
    Container contentPane = outputFrame.getContentPane();
    JPanel infoPanel      = new JPanel();

    // set layout
    infoPanel.setLayout(new GridLayout(4,1));

    infoPanel.add(new JLabel("Total Number Of Strings "+ numStrings));
    infoPanel.add(new JLabel("Total Number Of Well Formed Strings "+ wellFormed));
    infoPanel.add(new JLabel("Total Number Of Ill Formed Strings "+ illFormed));
    infoPanel.add(new JLabel("Program completed. Close window to exit program."));
    contentPane.add(infoPanel);

    // show information
    outputFrame.show();
  }
}