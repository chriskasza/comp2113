//*******
//
// TriviaGameGUI.java
//
//*******

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TriviaGameGUI extends JPanel
{
  JPanel titlePanel = new JPanel();
  JPanel statusPanel = new JPanel();
  JPanel choosePanel = new JPanel();
  JPanel categoryPanel = new JPanel(); 
  JPanel askPanel = new JPanel();
  JPanel questionPanel = new JPanel();
  JPanel enterAnswerPanel = new JPanel();
  JPanel answerPanel = new JPanel();
  JPanel submitPanel = new JPanel();
  JPanel nextPanel = new JPanel();

  JLabel titleLabel = new JLabel();
  JLabel correctLabel = new JLabel();
  JLabel incorrectLabel = new JLabel();
  JLabel remainingLabel = new JLabel();
  JLabel chooseLabel = new JLabel();
  JLabel askLabel = new JLabel();
  JLabel questionLabel = new JLabel();
  JLabel enterAnswerLabel = new JLabel();
  JLabel submitLabel = new JLabel();
  JLabel resultLabel = new JLabel();
  JLabel nextLabel = new JLabel();
  
  JButton askButton = new JButton();
  JButton submitButton = new JButton();
  JButton nextButton = new JButton();
  JRadioButton[] categories;
  ButtonGroup catGroup = new ButtonGroup();
  
  JTextField answerTextField = new JTextField(30);

  TriviaGame game;

  // Obtains game info and creates the screen
  public TriviaGameGUI(TriviaGame game)
  {
//  choosePanel.setBackground(new Color(0,122,0));   do I want to do this??
    this.game = game;

    // set panel layouts
    titlePanel.setLayout(new FlowLayout());
    statusPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
	 choosePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    categoryPanel.setLayout(new GridLayout(0, 4));
	 askPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	 questionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	 enterAnswerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	 submitPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	 nextPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    // set Label fonts
    Font quizBigFont = new Font("Helvetica Bold", Font.BOLD, 30);
    Font quizMidFont = new Font("Helvetica Bold", Font.BOLD, 20);
    Font quizSmallFont = new Font("Helvetica Bold", Font.BOLD, 15);
    titleLabel.setFont(quizBigFont);
	 correctLabel.setFont(quizMidFont);
	 incorrectLabel.setFont(quizMidFont);
	 remainingLabel.setFont(quizMidFont);
	 chooseLabel.setFont(quizSmallFont);
	 askLabel.setFont(quizSmallFont);
    questionLabel.setFont(quizSmallFont);
	 enterAnswerLabel.setFont(quizSmallFont);
	 submitLabel.setFont(quizSmallFont);
	 resultLabel.setFont(quizSmallFont);
	 nextLabel.setFont(quizSmallFont);

    // set non game status text values
    chooseLabel.setText("1. Choose a category:");
	 askLabel.setText("2. ");
	 askButton.setText("Submit category");
    questionLabel.setText("3. Question:");
    enterAnswerLabel.setText("4. Answer:");
	 submitLabel.setText("5. ");
	 submitButton.setText("Submit Answer");
	 resultLabel.setText("    ");
	 nextLabel.setText("6. ");
	 nextButton.setText("    Next     ");
	 	 
    // set question category buttons; assumes there is at least one question
    TriviaQuestion tq;
	 int numQuestions = game.getCurrNumQuestions();
	 categories = new JRadioButton[numQuestions];
    tq = game.getTriviaQuestion(1);
    categories[0] = new JRadioButton(tq.getCategory(),true);
    categoryPanel.add(categories[0]);
	 catGroup.add(categories[0]);
    for (int i = 2; i <= numQuestions; i++)
	 {
	   tq = game.getTriviaQuestion(i);
		categories[i-1] = new JRadioButton(tq.getCategory());
  	   categoryPanel.add(categories[i-1]);
		catGroup.add(categories[i-1]);
    }

	 // set game status text values
    setGameValues();

    // add info to panels
    titlePanel.add(titleLabel);
    statusPanel.add(correctLabel);
    statusPanel.add(incorrectLabel);
    statusPanel.add(remainingLabel);
    choosePanel.add(chooseLabel);
	 choosePanel.add(categoryPanel);
	 askPanel.add(askLabel);
	 askButton.addActionListener(new askButton());
	 askPanel.add(askButton);
    questionPanel.add(questionLabel);
    enterAnswerPanel.add(enterAnswerLabel);
	 enterAnswerPanel.add(answerTextField);
	 submitPanel.add(submitLabel);
	 submitButton.addActionListener(new submitButton());
	 submitPanel.add(submitButton);
	 submitPanel.add(resultLabel);
	 nextButton.addActionListener(new nextButton());
    nextPanel.add(nextLabel);
	 nextPanel.add(nextButton);

    // build overall interface
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(titlePanel);
	 add(statusPanel);
	 add(choosePanel);
	 add(askPanel);
    add(questionPanel);
	 add(enterAnswerPanel);
	 add(answerPanel);
	 add(submitPanel);
	 add(nextPanel);
  }

  public void display(int height)
  {
    JFrame theFrame = new JFrame("Trivia Game");
    theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theFrame.setContentPane(this);
    theFrame.setPreferredSize(new Dimension(600, height));

    theFrame.pack();
    theFrame.setVisible(true);
  }
 
  private void setGameValues()
  {
    titleLabel.setText("Quiz: " + game.getQuizName());
    correctLabel.setText("Correct: " + game.getNumCorrect());
    incorrectLabel.setText("Incorrect: " + game.getNumIncorrect());
    remainingLabel.setText("Remaining Chances: " + game.getRemainingChances());

    // disable category buttons of answered questions and
	 // select first available button
	 boolean first = true;
	 int numQuestions = game.getCurrNumQuestions();
    for (int i = 1; i <= numQuestions; i++)
      if (game.isAnswered(i))
		  categories[i-1].setEnabled(false);
		else
		if (first)
		{		  
	     categories[i-1].setSelected(true);
		  first = false;
		}
  }
	  
  class askButton implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
	 {
	   TriviaQuestion tq;
		int numQuestions = game.getCurrNumQuestions();
	   int selectedIndex = -1;
      for (int i = 0; i < numQuestions; i++)
	   {
		  if (categories[i].isSelected())
		    selectedIndex = i;
	   }
		tq = game.getTriviaQuestion(selectedIndex + 1);
	   questionLabel.setText("3. Question: " + tq.getQuestion());
    }
  }

  class submitButton implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
	 {
	   TriviaQuestion tq;
		int numQuestions = game.getCurrNumQuestions();
	   int selectedIndex = -1;
      for (int i = 0; i < numQuestions; i++)
	   {
		  if (categories[i].isSelected())
		    selectedIndex = i;
	   }
		tq = game.getTriviaQuestion(selectedIndex + 1);
		if (tq.tryAnswer(answerTextField.getText()))
		{
        resultLabel.setText("    Correct");
		  game.correctAnswer(selectedIndex + 1);
		}
      else
		{
		  resultLabel.setText("    Incorrect");
		  game.incorrectAnswer();
		}
    }
  }

  class nextButton implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
	 {
	   setGameValues();
	   questionLabel.setText("3. Question: ");
      resultLabel.setText("");
		answerTextField.setText("");
    }
  }
}