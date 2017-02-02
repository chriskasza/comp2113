package assignment12;

import java.util.ArrayList;

/**
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  12
 * Version:       1.0
 * File:          DictionaryADT.java
 *
 * Abstract class for Dictionary ADT.
 */

public abstract class DictionaryADT {
	protected ArrayList<String> list;
	protected int comparisons;
	
	public DictionaryADT() {
		list = new ArrayList<String>();
		comparisons = 0;
	}
	
	/**
	 * 
	 * @param s new string to be added to the dictionary
	 */
	public abstract void add(String s);
	
	/**
	 * 
	 * @param s string to be deleted from dictionary
	 */
	public abstract void delete(String s);

	/**
	 * 
	 * @param s string to be searched for in the dictionary
	 * @return index value of list if element exists 
	 *         and -1 if element does not exist
	 */
	public abstract int find(String s);
	
	public boolean isEmpty() {
		return (list.size() == 0);
	}
	
	public ArrayList<String> getList(){
		return list;
	}
	
	public Integer getComps() {
		return comparisons;
	}
	
	public void emptyList() {
		list.clear();
	}
}
