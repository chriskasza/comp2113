//----------------------------------------------------------------------------
// TDBinarySearchTree.java         by Dale/Joyce/Weems               Chapter 8
//
// Test Driver for the BinarySearchTree class
//----------------------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import ch08.trees.*;

public class TDBinarySearchTree
{

  public static void main(String[] args) throws IOException 
  {
    String testName = "BinarySearchTree";
    String command = null;
    int numCommands = 0;

    BinarySearchTree tree;
    int treeSize;
    String aString, bString;
  
    tree = new BinarySearchTree();
    
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

    // Process commands
    while(!command.equals("quit"))
    {
      if (command.equals("BinarySearchTree"))
      {
        tree = new BinarySearchTree();
        outFile.println("The tree is instantiated");
      }
      else 
      if (command.equals("isEmpty"))
      {
        outFile.println("The tree is empty is " + tree.isEmpty());
      }
      else 
      if (command.equals("isFull"))
      {
        outFile.println("The tree is full is " + tree.isFull());
      }
      else 
      if (command.equals("numberOfNodes"))
      {
        outFile.println("The number of nodes in the tree is " + tree.numberOfNodes());
      }
      else 
      if (command.equals("numberOfNodes2"))
      {
        outFile.println("The (iterative) number of nodes in the tree is " + tree.numberOfNodes2());
      }
      else 
      if (command.equals("isThere"))
      {
        aString = new String(dataFile.readLine());
        outFile.println(aString + " is on the tree: " + tree.isThere(aString));
      }
      else 
      if (command.equals("retrieve"))
      {
        aString = new String(dataFile.readLine());
        bString = (String)tree.retrieve(aString);
        outFile.println(bString + " was retrieved from the tree");
      }
      else 
      if (command.equals("insert"))
      {
        aString = new String(dataFile.readLine());
        tree.insert(aString);
        outFile.println(aString + " was inserted into the tree");
      }
      else 
      if (command.equals("delete"))
      {
        aString = new String(dataFile.readLine());
        tree.delete(aString);
        outFile.println(aString + " was deleted from the tree");
      }
      else 
      if (command.equals("reset"))
      {
        aString = new String(dataFile.readLine());
        if (aString.compareTo("PREORDER") == 0)
          treeSize = tree.reset(BinarySearchTree.PREORDER);
        else
        if (aString.compareTo("INORDER") == 0)
          treeSize = tree.reset(BinarySearchTree.INORDER);
        else
        if (aString.compareTo("POSTORDER") == 0)
          treeSize = tree.reset(BinarySearchTree.POSTORDER);
        outFile.println("reset invoked with " + aString);
      }
      else 
      if (command.equals("getNextItem"))
      {
        aString = new String(dataFile.readLine());
        bString = "";
        if (aString.compareTo("PREORDER") == 0)
          bString = (String) tree.getNextItem(BinarySearchTree.PREORDER);
        else
        if (aString.compareTo("INORDER") == 0)
          bString = (String) tree.getNextItem(BinarySearchTree.INORDER);
        else
        if (aString.compareTo("POSTORDER") == 0)
          bString = (String) tree.getNextItem(BinarySearchTree.POSTORDER);
        outFile.println("the next tree item is " + bString);
      }
      else 
      if (command.equals("printTree"))
      {
        aString = new String(dataFile.readLine());
        if (aString.compareTo("PREORDER") == 0)
        {
          treeSize = tree.reset(BinarySearchTree.PREORDER);
          outFile.println("The tree in Preorder is:");
          for (int count = 1; count <= treeSize; count++)
          {
            bString = (String) tree.getNextItem(BinarySearchTree.PREORDER);
            outFile.println(count + ". " + bString);
          }
        }
        else
        if (aString.compareTo("INORDER") == 0)
        {
          treeSize = tree.reset(BinarySearchTree.INORDER);
          outFile.println("The tree in Inorder is:");
          for (int count = 1; count <= treeSize; count++)
          {
            bString = (String) tree.getNextItem(BinarySearchTree.INORDER);
            outFile.println(count + ". " + bString);
          }
        }
        else
        if (aString.compareTo("POSTORDER") == 0)
        {
          treeSize = tree.reset(BinarySearchTree.POSTORDER);
          outFile.println("The tree in Postorder is:");
          for (int count = 1; count <= treeSize; count++)
          {
            bString = (String) tree.getNextItem(BinarySearchTree.POSTORDER);
            outFile.println(count + ". " + bString);
          }
        }
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