//----------------------------------------------------------------------
// TriviaGUI.java         by Dale/Joyce/Weems                  Chapter 2
//
// Allows the user to play a trivia game.
// Uses a GUI interface.
//----------------------------------------------------------------------

import java.io.*;

public class TriviaGUI 
{
  public static void main(String[] args) throws IOException
  {
	 int numQuestions;
    int height;
  	 TriviaGame game;    // the trivia game
	 
    // Initialze the game
	 game = GetTriviaGame.useTextFile("game.txt");
    TriviaGameGUI gameGUI = new TriviaGameGUI(game);
	 
    numQuestions = game.getCurrNumQuestions();
    height = 300 + (80 * (numQuestions / 4));
    
    gameGUI.display(height);

  }
}