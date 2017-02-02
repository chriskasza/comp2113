package assignment8;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 08
 * Version:      1.0
 * File:         BTree.java
 *
 * An implementation of a LCRS binary search tree ADT. 
 * 
 */

public class BTree {
	
	public class Node 
	{
		protected String label;  // the label of the node
		protected Node parent;   // a link to the parent node
		protected Node lmc;      // a link to the left-most child node
		protected Node rs;       // a link to the right sibling node
	}  

	protected Node root;         // reference to the root of the tree

	public BTree(String l) {
		// construct a new tree where root stores l
		root = new Node();
		
		root.label = l;
	}
	
	public BTree(Node n) {
		// construct a new tree where n is the root
		root = n;
	}
	
	public Node parent(Node n) {
		// return the parent Node of n
		return n.parent;
	}
	
	public Node leftmostChild(Node n) {
		// return the left-most child Node of n
		return n.lmc;
	}
	
	public Node rightSibling(Node n) {
		// return the right sibling Node of n
		return n.rs;
	}
	
	public String label(Node n) {
		// return the label stored in n
		return n.label;
	}
	
	public Node root() {
		return root;
	}
	
	public void makenull() {
		root = null;
	}

	public BTree insertChild(Node n, String l) {
		// add a new Node as the left-most child of n
		BTree newTree;
		Node newNode = new Node();
		newNode.label = l;
		
		if(n.lmc == null) {
			n.lmc = newNode;
		} else {
			newNode.rs = n.lmc;
			n.lmc = newNode;
		}
		
		newTree = new BTree(n);
		return newTree;
	}
	
	public BTree insertSibling(Node n, String l) {
		// add a new Node as the right sibling of n
		BTree newTree;
		Node newNode = new Node();
		newNode.label = l;
		
		if(n.rs == null) {
			n.rs = newNode;
			newNode.parent = n;
		} else {
			newNode.parent = n;
			newNode.rs = n.lmc;
			n.lmc = newNode;
		}
		
		newTree = new BTree(n);
		return newTree;
	}
	
	public boolean isEmpty() {
		// return whether the tree is empty
		return (root == null);
	}
	
}
