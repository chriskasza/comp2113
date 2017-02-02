//----------------------------------------------------------------------------
// BSTInterface.java            by Dale/Joyce/Weems                  Chapter 8
//
// Interface for a class that implements a Binary Search Tree of unique elements,
// i.e., no duplicate elements as defined by the key of the tree elements. 
//----------------------------------------------------------------------------

package ch08.trees;

public interface BSTInterface

{
  // used to specify traversal order
  public static final int INORDER = 1;
  public static final int PREORDER = 2;
  public static final int POSTORDER = 3;

  public boolean isEmpty();
  // Effect: 	     Determines whether this BST is empty.
  // Postcondition:  Return value = (this BST is empty)

  public boolean isFull();
  // Effect: 	     Determines whether this BST is full.
  // Postcondition:  Return value = (this BST is full)

  public int numberOfNodes();
  // Effect:         Determines the number of nodes in this BST.
  // Postcondition:  Return value = number of nodes in this BST

  public boolean isThere (Comparable item);
  // Effect:         Determines if element matching item is in this BST.
  // Postcondition:  Return value = (element with the same key as item is in this BST)
  
  public Comparable retrieve(Comparable item);
  // Effect:         Returns the BST element with the same key as item.
  // Preconditions:  An element with the same key as item is in this BST.
  // Postcondition:  Return value = (reference to BST element that matches item)

  public void insert (Comparable item);
  // Effect:         Adds item to this BST.
  // Preconditions:  This BST is not full.
  //                 Element matching item is not in this BST.
  // Postcondition:  Item is in this BST. 
  
  public void delete (Comparable item);
  // Effect:         Delete the element of this BST whose key matches item’s key.
  // Preconditions:  One and only one element in this BST has a key matching item’s key.
  // Postcondition:  No element in this BST has a key matching the argument item’s key.
  
  public int reset(int orderType);
  // Effect:         Initializes current position for an iteration through this BST
  //                 in orderType order
  // Postcondition:  Current position is first element for the orderType order
  //                 Returns current number of nodes in the tree

  public Comparable getNextItem (int orderType);
  // Effect:         Returns a copy of the element at the current position in this BST and
  //                 advances the value of the current position based on the orderType set 
  //                 through reset
  // Preconditions:  Current position for this ordertype is defined.
  //                 There exists a BST element at current position.
  //                 No BST transformers have been called since most recent call to reset.
  // Postconditions: Return value = (a copy of element at current position)
}