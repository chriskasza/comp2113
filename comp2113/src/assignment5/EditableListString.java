package assignment5;

import ch04.genericLists.*;

public class EditableListString implements Listable
{
	protected String key;

	public EditableListString(String inString)
	{
		key = new String(inString);
	}

	public Listable copy()
	{
		EditableListString result = new EditableListString(this.key);
		return result;
	}
	
	public void setKey(String inString)
	{
		key = inString;
	}

	public int compareTo(Listable otherListString)
	{
	 EditableListString other = (EditableListString)otherListString;
	 return this.key.compareTo(other.key); 
	}

	public String toString()
	{
		return(key);
	}
}
