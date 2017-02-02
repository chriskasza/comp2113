//----------------------------------------------------------------------------
// TriviaGame.java             by Dale/Joyce/Weems                   Chapter 2
//
// Provides trivia game objects.
//----------------------------------------------------------------------------

public class TriviaGame
{
  private String quizName;
  private int maxNumQuestions;
  private int numChances;
  private int remainingChances;
  private int numCorrect = 0;
  private int numIncorrect = 0;
  private TriviaQuestion[] questions;  // the set of questions
  private boolean[] correct;           // true if corresponding question answered
  private int currNumQuestions = 0;    // current number of questions

  public TriviaGame(String quizName, int maxNumQuestions, int numChances)
  // Precondition:  maxNumQuestions > 0 and numChances > 0
  {
    this.quizName = quizName;
    this.maxNumQuestions = maxNumQuestions;
    this.numChances = numChances;
    remainingChances = numChances;
    questions = new TriviaQuestion[maxNumQuestions];
    correct = new boolean[maxNumQuestions];
  }

  public String getQuizName()
  {
    return quizName;
  }

  public int getNumChances()
  {
    return numChances;
  }

  public int getRemainingChances()
  {
    return remainingChances;
  }

  public int getNumCorrect()
  {
    return numCorrect;
  }

  public int getNumIncorrect()
  {
    return numIncorrect;
  }

  public int getCurrNumQuestions()
  {
    return currNumQuestions;
  }
  
  public TriviaQuestion getTriviaQuestion(int questionNumber)
  // Precondition:   0 < questionNumber <= currNumQuestions
  {
    return questions[questionNumber - 1];
  }

  public boolean isAnswered(int questionNumber)
  // Precondition:   0 < questionNumber <= currNumQuestions
  {
    return correct[questionNumber - 1];
  }
  
  public boolean isOver()
  // Returns true if this game is over, false otherwise.
  {
    return (numCorrect == currNumQuestions)
           ||
           (remainingChances <= 0);
  }

  public void insertQuestion(TriviaQuestion question)
  // Precondition:  currNumQuestions < maxNumQuestions
  // 
  // Adds question to this TriviaGame.
  {
    questions[currNumQuestions] = question;
    correct[currNumQuestions] = false;      
    currNumQuestions = currNumQuestions + 1;
  }
  
  public void correctAnswer(int questionNumber)
  // Preconditions: 0 < questionNumber < maxNumQuestions
  //
  // Updates game status to indicate that question number 
  // "questionNumber" was answered correctly.
  {
    correct[questionNumber - 1] = true;
    numCorrect = numCorrect + 1;
    remainingChances = remainingChances - 1;
  }

  public void incorrectAnswer()
  // Updates game status to indicate that a question 
  // was answered incorrectly
  {
    numIncorrect = numIncorrect + 1;
    remainingChances = remainingChances - 1;
  } 
}