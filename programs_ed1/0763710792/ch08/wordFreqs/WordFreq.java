//----------------------------------------------------------------------------
// WordFreq.java              by Dale/Joyce/Weems                    Chapter 8
//
// Defines word-frequency pairs
//----------------------------------------------------------------------------

package ch08.wordFreqs;

import java.text.DecimalFormat;

public class WordFreq implements Comparable
{
  private String word;
  private int freq;

  DecimalFormat fmt = new DecimalFormat("00000");


  public WordFreq(String newWord)
  {
    word = newWord;
    freq = 0;
   }

  public void inc()
  {
    freq = freq + 1;
  }

  public int compareTo(Object otherWordFreq)
  {
   WordFreq other = (WordFreq)otherWordFreq;
   return this.word.compareTo(other.word); 
  }

  public String toString()
  {
    return(fmt.format(freq) + " " + word);
  }

  public String wordIs()
  {
    return word;
  }

  public int freqIs()
  {
    return freq;
  }
}
 