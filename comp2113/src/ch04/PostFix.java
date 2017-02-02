//----------------------------------------------------------------------------
// PostFix.java               by Dale/Joyce/Weems                    Chapter 4
//
// Evaluates posfix expressions
//----------------------------------------------------------------------------

import java.awt.*;            
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import ch04.postfix.*;

public class PostFix
{
  // text field
  private static JTextField expressionText;  // text field for postfix expression

  // status Label
  private static JLabel statusLabel;         // Label for status/result info

  // push statistics labels
  private static JLabel countValue;           
  private static JLabel minimumValue;           
  private static JLabel maximumValue;           
  private static JLabel averageValue;           

  // to track "push" statistics
  private static IntSetStats pushInts;

  // Define a button listener
  private static class ActionHandler implements ActionListener 
  {
    public void actionPerformed(ActionEvent event)
    // Listener for the button events
    {
      if (event.getActionCommand().equals("Evaluate"))
      { // Handles Evaluate event
        String result;
        try
        {
          pushInts = new IntSetStats();
          result = PostFixEvaluator.evaluate(expressionText.getText(), pushInts);
          countValue.setText(pushInts.getCount());
          minimumValue.setText(pushInts.getMin());
          maximumValue.setText(pushInts.getMax());
          averageValue.setText(pushInts.getAverage());
        }
        catch (PostFixException error)
        {        
          result = error.getMessage();
        }
        statusLabel.setText("Result = " + result); 
      }
      else
      if (event.getActionCommand().equals("Clear"))
      { // Handles Clear event
        statusLabel.setText("cleared");
        countValue.setText("");
        minimumValue.setText("");
        maximumValue.setText("");
        averageValue.setText("");
        expressionText.setText("");
      }
    }
  }

  public static void main(String args[]) throws IOException
  {
    // Declare/instantiate/initialize display frame
    JFrame displayFrame = new JFrame();
    displayFrame.setTitle("PostFix Expression Evaluator Program");
    displayFrame.setSize(400,150);
    displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    displayFrame.setDefaultCloseOperation(3);

    // text box for expression
    expressionText = new JTextField("postfix expression goes here", 60);

    // Status/Result label
    statusLabel = new JLabel("status", JLabel.CENTER);
    statusLabel.setBorder(new LineBorder(Color.red,3));

    // Labels for "push" statistics output
    JLabel headerLabel   = new JLabel("Push Statistics", JLabel.LEFT);           
    JLabel blankLabel   = new JLabel("");
    JLabel blankLabel2  = new JLabel("");            
    JLabel blankLabel3  = new JLabel("");            
    JLabel countLabel   = new JLabel("Count: ", JLabel.RIGHT);           
    JLabel minimumLabel = new JLabel("Minimum: ", JLabel.RIGHT);           
    JLabel maximumLabel = new JLabel("Maximum: ", JLabel.RIGHT);           
    JLabel averageLabel = new JLabel("Average: ", JLabel.RIGHT);           
    countValue   = new JLabel("", JLabel.LEFT);           
    minimumValue = new JLabel("", JLabel.LEFT);           
    maximumValue = new JLabel("", JLabel.LEFT);           
    averageValue = new JLabel("", JLabel.LEFT);           

    // Evaluate and clear buttons    
    JButton evaluate   = new JButton("Evaluate");         
    JButton clear       = new JButton("Clear");	       

    // Button event listener
    ActionHandler action = new ActionHandler();
 
    // Register button listeners
    evaluate.addActionListener(action);
    clear.addActionListener(action);

    // Instantiate content pane and information panels
    Container contentPane = displayFrame.getContentPane();
    JPanel expressionPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel labelPanel = new JPanel();
 
    // Initialize expression panel
    expressionPanel.setLayout(new GridLayout(2,1));
    expressionPanel.add(expressionText);
    expressionPanel.add(statusLabel);

    // Initialize button panel
    buttonPanel.setLayout(new GridLayout(1,2));
    buttonPanel.add(evaluate);
    buttonPanel.add(clear);

    // Initialize label panel
    labelPanel.setLayout(new GridLayout(3,4));
    labelPanel.add(headerLabel);
    labelPanel.add(blankLabel);
    labelPanel.add(blankLabel2);
    labelPanel.add(blankLabel3);
    labelPanel.add(countLabel);
    labelPanel.add(countValue);
    labelPanel.add(maximumLabel);
    labelPanel.add(maximumValue);
    labelPanel.add(averageLabel);
    labelPanel.add(averageValue);
    labelPanel.add(minimumLabel);
    labelPanel.add(minimumValue);

    // set up and show the frame
    contentPane.add(expressionPanel, "North");
    contentPane.add(buttonPanel, "Center");
    contentPane.add(labelPanel, "South");

    displayFrame.show();      
  }
}
