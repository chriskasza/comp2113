//----------------------------------------------------------------------------
// Towers.java             by Dale/Joyce/Weems                       Chapter 7
//
// Driver class for doTowers method
// The number of circles is the first command line parameter.
// The output file name is the second command line parameter.
//----------------------------------------------------------------------------

import java.io.*;        
 
public class Towers
{
  private static PrintWriter outFile;    // Output data file
 
  public static void main(String[] args) throws IOException
  {
    // Prepare outputfile
    String outFileName = args[1];
    outFile = new PrintWriter(new FileWriter(outFileName));

    // Get number of circles on starting peg
    int circleCount;    
    circleCount = Integer.valueOf(args[0]).intValue();
 
    outFile.println("OUTPUT WITH " + circleCount + " CIRCLES");
    outFile.println("From original: ");
    doTowers(circleCount, 1, 2, 3);
    outFile.close();
  }
 
  public static void doTowers(
         int circleCount,    // Number of circles to move
         int beginPeg,       // Peg containing circles to move
         int auxPeg,         // Peg holding circles temporarily
         int endPeg      )   // Peg receiving circles being moved
  //  Moves are written on file outFile
  //  This recursive method moves circleCount circles from beginPeg
  //  to endPeg.  All but one of the circles are moved from beginPeg
  //  to auxPeg, then the last circle is moved from beginPeg to
  //  endPeg, and then the circles are moved from auxPeg to endPeg.
  //  The subgoals of moving circles to and from auxPeg are what
  //  involve recursion
  {
    outFile.println("#circles: " + circleCount + " Begin: " +
      beginPeg + " Auxil: " + auxPeg + " End: " + endPeg);
    if (circleCount > 0)
    {
      // Move n - 1 circles from beginning peg to auxiliary peg
      outFile.println("From first:   ");
      doTowers(circleCount - 1, beginPeg, endPeg, auxPeg);
      outFile.println("Move circle from peg " + beginPeg
              + " to peg " + endPeg);
 
      // Move n - 1 circles from auxiliary peg to ending peg
      outFile.println("From Second:  ");
      doTowers(circleCount - 1, auxPeg, beginPeg, endPeg);
    }
  }
}
