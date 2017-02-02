//----------------------------------------------------------------------------
// FrequencyList.java            by Dale/Joyce/Weems                 Chapter 8
//
// Creates a word frequency list of the words listed in the input file.
// Writes the list to the output file.
// Does not process words less than minSize in length.
// Does not output words unless their frequency is at least minFreq.
// Command line parameters are assumed valid, as follows:
//   first: input file name
//   second: output file name
//   third: value of minSize
//   four: value of minFreq
//----------------------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;
import ch08.trees.*;
import ch08.wordFreqs.*;

public class FrequencyList
{
  private static Frame outputDisplay;

  public static void main(String[] args) throws IOException 
  {
    String inLine = null;
    String word;
    WordFreq wordToTry;
    WordFreq wordInTree;
    WordFreq wordFromTree;

    BinarySearchTree2 tree = new BinarySearchTree2();
    StringTokenizer tokenizer;

    int numWords = 0;
    int numValidWords = 0;
    int numValidFreqs = 0;
    int treeSize;

    //Get file name arguments from command line as entered by user
    String dataFileName = args[0];
    String outFileName  = args[1];

    BufferedReader dataFile = new BufferedReader(new FileReader(dataFileName));
    PrintWriter outFile = new PrintWriter(new FileWriter(outFileName));

    //Get word and freq limits from command line as entered by user
    int minSize = Integer.parseInt(args[2]);
    int minFreq = Integer.parseInt(args[3]);

    inLine = dataFile.readLine();
    while (inLine != null)
    {
      tokenizer = new StringTokenizer(inLine, " \t\n\r\\\"!@#$&*()_-+={}[]:;'<,>.?/");
      while (tokenizer.hasMoreTokens())
      {
        word = tokenizer.nextToken();
        numWords = numWords + 1;
        if (word.length() >= minSize)
        {
          numValidWords = numValidWords + 1;
          word = word.toLowerCase();
          wordToTry = new WordFreq(word);

          wordInTree = (WordFreq)tree.find(wordToTry);
          if (wordInTree == null)
          {
            // insert new word into tree
            wordToTry.inc();               // set frequency to 1
            tree.insert(wordToTry);
          }
          else
          {
            // word already in tree, just increment frequency
            wordInTree.inc();
          }
        }
      }
      inLine = dataFile.readLine();
    }

    treeSize = tree.reset(BinarySearchTree.INORDER);
    outFile.println("The words of length " + minSize + " and above,");
    outFile.println("with frequency counts of " + minFreq + " and above:");
    outFile.println();
    outFile.println("Freq  Word");
    outFile.println("----- -----------------");
    for (int count = 1; count <= treeSize; count++)
    {
      wordFromTree = (WordFreq) tree.getNextItem(BinarySearchTree.INORDER);
      if (wordFromTree.freqIs() >= minFreq)
      {
        numValidFreqs = numValidFreqs + 1;
        outFile.println(wordFromTree);
      }
    }

    //Close files
    dataFile.close();
    outFile.close(); 

    //Set up output frame
    JFrame outputFrame = new JFrame();
    outputFrame.setTitle("Frequency List Generator");
    outputFrame.setSize(400,100);
    outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    // Instantiate content pane and information panel
    Container contentPane = outputFrame.getContentPane();
    JPanel infoPanel      = new JPanel();

    // set layout
    infoPanel.setLayout(new GridLayout(4,1));

    // create labels
    JLabel numWordsInfo = new JLabel(numWords + " words in the input file.  ");
    JLabel numValidWordsInfo = new JLabel(numValidWords + " of them are at least " + minSize + " characters.");
    JLabel numValidFreqsInfo = new JLabel(numValidFreqs + " of these occur at least " + minFreq + " times.");
    JLabel finishedInfo = new JLabel("Program completed. Close window to exit program.");

    // add information
    infoPanel.add(numWordsInfo);
    infoPanel.add(numValidWordsInfo);
    infoPanel.add(numValidFreqsInfo);
    infoPanel.add(finishedInfo);
    contentPane.add(infoPanel);

    // show information
    outputFrame.show();
  } 
} 