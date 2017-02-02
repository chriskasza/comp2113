//----------------------------------------------------------------------------
// GetTriviaGame.java            by Dale/Joyce/Weems                 Chapter 2
//
// Provides methods that obtain information about a Trivia Game, create and
// return TriviaGame objects.
//
// Note: Currently only option is to obtain a game from a text file, but
//       other options could be added later.
//----------------------------------------------------------------------------

import java.util.*;
import java.io.*;

public class GetTriviaGame
{
  public static TriviaGame useTextFile(String textfile)throws IOException
  // Precondition:  The textfile exists and contains a correctly formatted game.
  {
    TriviaGame game;

    String quizName;
    int numQuestions;
    int numChances;

    // for a specific trivia question
    TriviaQuestion tq;
    String category;
    String question;
    String answer;
    int numAnswers;
	 
    FileReader fin = new FileReader(textfile);
    Scanner triviaIn = new Scanner(fin);
    String skip;        // skip end of line after reading integer
	 
    // Scan in basic trivia quiz information and set variables.
    quizName = triviaIn.nextLine();
    numQuestions = triviaIn.nextInt();
    numChances = triviaIn.nextInt();
    skip = triviaIn.nextLine();

    // Instantiate the Trivia Game.
    game = new TriviaGame(quizName, numQuestions, numChances);

    // Scan in and set up the questions and answers.
    for (int i = 1; i <= numQuestions; i++)
    {
      category = triviaIn.nextLine();
      question = triviaIn.nextLine();
      numAnswers = triviaIn.nextInt();
      skip = triviaIn.nextLine();
      tq = new TriviaQuestion(category, question, numAnswers);
      for (int j = 1; j <= numAnswers; j++)
      {
        answer = triviaIn.nextLine();
        tq.storeAnswer(answer);
      }
      game.insertQuestion(tq);
    }
	
    return game;
  }
}