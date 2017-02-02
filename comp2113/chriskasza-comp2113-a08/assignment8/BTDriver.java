package assignment8;

import java.util.ArrayList;
import assignment8.BTree.Node;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 08
 * Version:      1.0
 * File:         BTDriver.java
 *
 * Driver to test the BTree class 
 * 
 */

public class BTDriver {
	public static ArrayList<String> queue;
	
	public static void main(String[] args) {
		queue = new ArrayList<String>();
		
		BTree t1 = new BTree("a");
		System.out.println("\nTable 1:");
		prints(t1);

		Node p = t1.root();
		BTree t2 = t1.insertChild(p, "b");
		System.out.println("\nTable 2:");
		prints(t2);
		
		p = t2.leftmostChild(t2.root());
		System.out.println("\nAdd sibling \"c\" to Table 2");
		t2 = t2.insertSibling(p, "c");
		
		p = t2.rightSibling(p);
		System.out.println("\nAdd sibling \"d\" to Table 2");
		t2 = t2.insertSibling(p, "d");

		System.out.println("\nAdd child \"e\" to Table 2");
		t2 = t2.insertChild(p, "e");
		
		p = t2.leftmostChild(p);
		System.out.println("\nAdd sibling \"f\" to Table 2");		
		t2 = t2.insertSibling(p, "f");
		
		System.out.println("\nTable 2:");
		prints(t2);
		
		System.out.println("\nTable 1:");
		prints(t1);
		
		System.out.println("\nThe size of table 1 is " + numberOfNodes(t1));
		System.out.println("\nThe height of table 1 is  " + height(t1));
		System.out.println("\nThe number of leaves of table 1 is " + leaves(t1));
	}
	
	public static void prints(BTree T) {
		queue.clear();
		printInorder(T);
		System.out.println("Print Inorder: " + queue.toString());
		
		queue.clear();
		printPostorder(T);
		System.out.println("Print Postorder: " + queue.toString());

		queue.clear();
		printPreorder(T);
		System.out.println("Print Preorder: " + queue.toString());
	}
	
	public static void printInorder(BTree T) {
		if(T != null) {			
			if(T.root().lmc != null) {
				printInorder(new BTree(T.root().lmc));
			}
			queue.add(T.root().label);
			if(T.root().rs != null) {
				printInorder(new BTree(T.root().rs));
			}			
		}
	}
	
	public static void printPostorder(BTree T) {
		if(T != null) {
			if(T.root().lmc != null) {
				printPostorder(new BTree(T.root().lmc));
			}
			if(T.root().rs != null) {
				printPostorder(new BTree(T.root().rs));
			}
			queue.add(T.root().label);
		}
	}
	
	public static void printPreorder(BTree T) {
		if(T != null) {			
			queue.add(T.root().label);
			if(T.root().lmc != null) {
				printPreorder(new BTree(T.root().lmc));
			}
			if(T.root().rs != null) {
				printPreorder(new BTree(T.root().rs));
			}
		}
	}
	
	public static int numberOfNodes(BTree T) {
		int count = 1;
		
		if(T == null) {
			return 0;
		}
		if(T.root().lmc != null) {
			count += numberOfNodes(new BTree(T.root().lmc));
		}
		if(T.root().rs != null) {
			count += numberOfNodes(new BTree(T.root().rs));
		}
		
		return count;
	}
	
	public static int height(BTree T) {
		int count = 1;
		
		if(T == null) {
			return 0;
		}
		if(T.root().lmc != null) {
			count += height(new BTree(T.root().lmc));
		}
		if(T.root().rs != null) {
			int c = height(new BTree(T.root().rs));
			
			if(c > count) {
				count = c;
			}			
		}
		
		return count;		
	}
	
	public static int leaves(BTree T) {
		int count = 0;
		
		if(T == null) {
			return 0;
		}
		
		if((T.root().lmc == null) && (T.root().rs == null)) {
			return 1;
		}
		
		if(T.root().lmc != null) {
			count += leaves(new BTree(T.root().lmc));
		}
		if(T.root().rs != null) {
			count += leaves(new BTree(T.root().rs));
		}
		
		return count;
	}
}
