//----------------------------------------------------------------------------
// Palindrome.java             by Dale/Joyce/Weems                   Chapter 4
//
// Checks for palindromes
// Input file consists of a sequence of strings, one per line
// Output file contains, for each string:
//    Whether or not the string is a palindrome ... blanks are ignored
// Input and output file names are supplied by user through command line parameters.
// Output frame supplies summary statistics
//----------------------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import ch04.stacks.*;
import ch04.queues.*;

public class Palindrome
{
  public static void main(String[] args) throws IOException 
  {
    final int maxStringSize = 180;   // maximum size of an input line
    int numStrings = 0;              // total number of strings processed
    int palindromes = 0;             // number of palindromes found
    int nonPalindromes = 0;          // number of non-palindromes found
    int tooLong = 0;                 // number of strings too long to process

    char ch;                         // current input string character being processed
    int numLetters;                  // number of letter characters in current string
    int charCount;                   // number of characters checked so far

    Character fromStack;             // current Char object popped from stack
    Character fromQueue;             // current Char object dequeued from queue
    boolean stillPalindrome;         // true as long as the string might still be a palindrome

    StackInterface stack;                // holds non-blank string characters
    QueueInterface queue;                // also holds non-blank string characters

    String line = null;              // input line
    String dataFileName = args[0];   // name of input file
    String outFileName = args[1];    // name of output file

    BufferedReader dataFile = new BufferedReader(new FileReader(dataFileName));
    PrintWriter outFile = new PrintWriter(new FileWriter(outFileName));
    DecimalFormat fmt = new DecimalFormat("000");

    outFile.println();               // print a blank line
    line = dataFile.readLine();      // read the first input line

    while(line!=null)                // while haven't read all of the input lines
    {
      numStrings = numStrings + 1;
      outFile.println("String " + fmt.format(numStrings) + ": " + line);

      if (line.length() > maxStringSize)
      {
        tooLong = tooLong + 1;
        outFile.println("String too long - processing skipped");
      }
      else
      {
        // check if line is a palindrome
        stack = new ArrayStack(maxStringSize);
        queue = new ArrayQueue(maxStringSize);
        numLetters = 0;

        for (int i = 0; i < line.length(); i++)
        {
          ch = line.charAt(i);
          if (Character.isLetter(ch))
          {
            numLetters = numLetters + 1;
            ch = Character.toLowerCase(ch);
            stack.push(new Character(ch));
            queue.enqueue(new Character(ch));
          }
        }

        stillPalindrome = true;
        charCount = 0;

        while (stillPalindrome && (charCount < numLetters))
        {
          fromStack = (Character)stack.top();
          stack.pop();
          fromQueue = (Character)queue.dequeue();
          if (!fromStack.equals(fromQueue))
            stillPalindrome = false;
          charCount++;
        }

        if (!stillPalindrome)
        {
          nonPalindromes = nonPalindromes + 1;
          outFile.println("            Not a palindrome ");
        }
        else
        {
          palindromes = palindromes + 1;
          outFile.println("            Is a palindrome.");
        }
      }
      outFile.println();
      line = dataFile.readLine();    // set up processing of next line
    }
    dataFile.close();
    outFile.close();

    //Set up output frame
    JFrame outputFrame = new JFrame();
    outputFrame.setTitle("Palindromes");
    outputFrame.setSize(300,200);
    outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
//    outputFrame.setDefaultCloseOperation(3);   

    // Instantiate content pane and information panel
    Container contentPane = outputFrame.getContentPane();
    JPanel infoPanel      = new JPanel();

    // set layout
    infoPanel.setLayout(new GridLayout(5,1));

    infoPanel.add(new JLabel("Total Number Of Strings "+ numStrings));
    infoPanel.add(new JLabel("Number Of Strings too long for Processing " + tooLong));
    infoPanel.add(new JLabel("Number Of Palindromes "+ palindromes));
    infoPanel.add(new JLabel("Number Of Non Palindromes "+ nonPalindromes));
    infoPanel.add(new JLabel("Program completed. Close window to exit program."));
    contentPane.add(infoPanel);

    // show information
    outputFrame.show();
  }
}