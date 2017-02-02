//----------------------------------------------------------------------
// TriviaConsole.java       by Dale/Joyce/Weems                Chapter 2
//
// Allows the user to play a trivia game.
// Uses a Console interface.
//----------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class TriviaConsole 
{
  public static void main(String[] args) throws IOException
  {
    Scanner conIn = new Scanner(System.in);
	 
	 TriviaGame game;    // the trivia game
	 
    int questNum;       // current question number
    TriviaQuestion tq;  // current question
    String answer;      // answer provided by user

    // Initialze the game
	 game = GetTriviaGame.useTextFile("game.txt");
	 
    // Greet the user.
    System.out.println("Welcome to the " + game.getQuizName() + " trivia quiz.");
    System.out.print("You will have " + game.getNumChances() + " chances ");
    System.out.println("to answer " + game.getCurrNumQuestions() + " questions.\n");

    questNum = 0;
    while (!game.isOver())
    {
	   // Get number of next unanswered question.
		do
		  if (questNum == game.getCurrNumQuestions())
		    questNum = 1;
		  else
		    questNum = questNum + 1;
		while (game.isAnswered(questNum));
				  
      // Ask question and handle user's response.
      tq = game.getTriviaQuestion(questNum);
      System.out.println(tq.getCategory() + ": " + tq.getQuestion());
      answer = conIn.nextLine();
      if (tq.tryAnswer(answer))
      {
        System.out.println("Correct!\n");
        game.correctAnswer(questNum);
      }
      else
      {
        System.out.println("Incorrect\n");
        game.incorrectAnswer();
      }
    }
   
    System.out.println("\nGame Over");
    System.out.println("\nResults:");
    System.out.print("   Chances used: " + (game.getNumChances() - game.getRemainingChances()));
    System.out.println("   Number Correct: " + game.getNumCorrect());
    System.out.println("\nThank you.\n");
  }
}