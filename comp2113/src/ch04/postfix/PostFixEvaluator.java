//----------------------------------------------------------------------------
// PostFixEvaluator.java          by Dale/Joyce/Weems                Chapter 4
//
// Provides a postfix expression evaluation
//----------------------------------------------------------------------------

package ch04.postfix;

import ch04.stacks.*;
import java.util.StringTokenizer;

public class PostFixEvaluator
{
  public static String evaluate(String expression, IntSetStats pushInts)
  {
    ArrayStack stack = new ArrayStack(50);  

    int value;
    Integer wrapValue;

    int operand1;
    int operand2;

    int result = 0;
    Integer wrapResult;

    String token;

    StringTokenizer tokenizer = new StringTokenizer(expression);

    while (tokenizer.hasMoreTokens())
    {
      token = tokenizer.nextToken();
      if (isNotOperator(token))
      {
        // process operand
        try
        {
          value = Integer.parseInt(token);
          wrapValue = new Integer(value);
        }
        catch (NumberFormatException badData)
        {
          throw new PostFixException("Illegal symbol: " + badData.getMessage());
        } 
        
        if (stack.isFull())
          throw new PostFixException("Too many operands - stack overflow");
        stack.push(wrapValue);
        pushInts.register(value);
      }
      else
      {
        // process operator
        if (stack.isEmpty())
          throw new PostFixException("Not enough operands - stack underflow");
        operand2 = ((Integer)stack.top()).intValue();
        stack.pop();

        if (stack.isEmpty())
          throw new PostFixException("Not enough operands - stack underflow");
        operand1 = ((Integer)stack.top()).intValue();
        stack.pop();

        if (token.equals("/"))
          result = operand1 / operand2;
        else
        if(token.equals("*"))
          result = operand1 * operand2;
        else
        if(token.equals("+"))
          result = operand1 + operand2;
        else
        if(token.equals("-"))
          result = operand1 - operand2;

        wrapResult = new Integer(result);
        stack.push(wrapResult);
        pushInts.register(result);
      }
    }

    if (stack.isEmpty())
      throw new PostFixException("Not enough operands - stack underflow");
    result = ((Integer)stack.top()).intValue();
    stack.pop();

    // stack should now be empty
    if (!stack.isEmpty())
      throw new PostFixException("Too many operands - operands left over");

    return Integer.toString(result);
  }

  private static boolean isNotOperator(String testThis)
  {
    if(testThis.equals("/") || testThis.equals("*") || 
       testThis.equals("-") || testThis.equals("+"))
      return false;
    else
      return true;
  }
}