//----------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems                Chapter 8
//
// Defines all constructs for a reference-based BST
//----------------------------------------------------------------------------

package ch08.trees;

import ch04.queues.*;
import ch05.stacks.*;

public class BinarySearchTree implements BSTInterface
{
  protected class BSTNode 
  {
    // Used to hold references to BST nodes for the linked implementation
    protected Comparable info;       // the info in a BST node
    protected BSTNode left;          // a link to the left child node
    protected BSTNode right;         // a link to the right child node
  }  
  
  protected BSTNode root;            // reference to the root of this BST

  // for traversals
  protected ArrayQueue inOrderQueue;  // queue of info
  protected ArrayQueue preOrderQueue;  // queue of info
  protected ArrayQueue postOrderQueue;  // queue of info

  public BinarySearchTree()
  // Creates an empty BST object.
  {
    root = null;
  }

  public boolean isEmpty()
  // Determines whether this BST is empty
  {
    return (root == null);
  }

  public boolean isFull()
  // Determines whether this BST is full
  {
    return false;
  }

  private int recNumberOfNodes(BSTNode tree)
  // Determines the number of nodes in tree
  {
    if (tree == null)    
      return 0;
    else
      return recNumberOfNodes(tree.left) + recNumberOfNodes(tree.right) + 1;
  }

  public int numberOfNodes()
  // Determines the number of nodes in this BST
  {
    return recNumberOfNodes(root);
  }

  public int numberOfNodes2()
  // Determines the number of nodes in this BST
  {
    int count = 0;
    if (root != null)
    {
      LinkedStack hold = new LinkedStack();
      BSTNode currNode;
      hold.push(root);
      while (!hold.isEmpty())
      {
        currNode = (BSTNode) hold.top();
        hold.pop();
        count++;
        if (currNode.left != null)
          hold.push(currNode.left);
        if (currNode.right != null)
          hold.push(currNode.right);
      }
    }
    return count;
  }

  private boolean recIsThere(Comparable item, BSTNode tree)
  // returns true if item is in tree, false otherwise
  {
    if (tree == null)
      return false;                      // item is not found
    else if (item.compareTo(tree.info) < 0)
      return recIsThere(item, tree.left);  // Search left subtree
    else if (item.compareTo(tree.info) > 0)
      return recIsThere(item, tree.right); // Search right subtree
    else
      return true;                         // item is found
  }

  public boolean isThere (Comparable item)
  // Determines if element matching item is in this BST.
  {
    return recIsThere(item, root);
  }
  
  private Comparable recRetrieve(Comparable item, BSTNode tree)
  // Returns the element in tree with the same key as item.
  {
    if (item.compareTo(tree.info) < 0)
      return recRetrieve(item, tree.left);          // retrieve from left subtree
    else
    if (item.compareTo(tree.info) > 0)
      return recRetrieve(item, tree.right);         // retrieve from right subtree
    else
      return tree.info;
  }

  public Comparable retrieve(Comparable item)
  // Returns the BST element with the same key as item.
  {
    return recRetrieve(item, root);
  }

  private BSTNode recInsert(Comparable item, BSTNode tree)
  // Inserts item into the tree
  {
    if (tree == null)
    {// Insertion place found
      tree = new BSTNode();
      tree.right = null;
      tree.left = null;
      tree.info = item;
    }
    else if (item.compareTo(tree.info) < 0)
      tree.left = recInsert(item, tree.left);    // Insert in left subtree
    else
      tree.right = recInsert(item, tree.right);   // Insert in right subtree
    return tree;
  }

  public void insert (Comparable item)
  // Adds item to this BST.
  {
    root = recInsert(item, root);
  }

  private Comparable getPredecessor(BSTNode tree)
  // Returns the info member of the rightmost node in tree
  {
    while (tree.right != null)
      tree = tree.right;
    return tree.info;
  }

  private BSTNode deleteNode(BSTNode tree)
  // Deletes the node referenced by tree
  // Post: The user's data in the node referenced to by tree is no
  //       longer in the tree.  If tree is a leaf node or has only
  //       a non-null child pointer, the node pointed to by tree is
  //       deleted; otherwise, the user's data is replaced by its
  //       logical predecessor and the predecessor's node is deleted
  {
    Comparable data;

    if (tree.left == null)
      return tree.right;
    else if (tree.right == null) 
      return tree.left;
    else
    {
      data = getPredecessor(tree.left);
      tree.info = data;
      tree.left = recDelete(data, tree.left);  // Delete predecessor node
      return tree;
    }
  }

  private BSTNode recDelete(Comparable item, BSTNode tree)
  // Deletes item from the tree
  {
    if (item.compareTo(tree.info) < 0)
      tree.left = recDelete(item, tree.left);
    else if (item.compareTo(tree.info) > 0)
      tree.right = recDelete(item, tree.right);
    else 
      tree = deleteNode(tree);
    return tree;
  }

  public void delete (Comparable item)
  // Delete the element of this BST whose key matches item’s key.
  {
    root = recDelete(item, root);
  }

  private void inOrder(BSTNode tree)
  // initializes inOrderQueue with tree elements in inOrder order
  {
    if (tree != null)
    {
      inOrder(tree.left);
      inOrderQueue.enqueue(tree.info);
      inOrder(tree.right);
    }
  }

  private void preOrder(BSTNode tree)
  // initializes preOrderQueue with tree elements in preOrder order
  {
    if (tree != null)
    {
      preOrderQueue.enqueue(tree.info);
      preOrder(tree.left);
      preOrder(tree.right);
    }
  }

  private void postOrder(BSTNode tree)
  // initializes postOrderQueue with tree elements in postOrder order
  {
    if (tree != null)
    {
      postOrder(tree.left);
      postOrder(tree.right);
      postOrderQueue.enqueue(tree.info);
    }
  }

  public int reset(int orderType)
  // Initializes current position for an iteration through this BST in orderType order
  {
    int numNodes = numberOfNodes();
    if (orderType == INORDER)
    {
      inOrderQueue = new ArrayQueue(numNodes);
      inOrder(root);
    }
    else
    if (orderType == PREORDER)
    {
      preOrderQueue = new ArrayQueue(numNodes);
      preOrder(root);
    }
    if (orderType == POSTORDER)
    {
      postOrderQueue = new ArrayQueue(numNodes);
      postOrder(root);
    }
    return numNodes;
  }

  public Comparable getNextItem (int orderType)
  // Returns a copy of the element at the current position in this BST and advances 
  // the value of the current position based on the orderType set through reset
  {
    if (orderType == INORDER)
      return (Comparable)inOrderQueue.dequeue();
    else
    if (orderType == PREORDER)
      return (Comparable)preOrderQueue.dequeue();
    else
    if (orderType == POSTORDER)
      return (Comparable)postOrderQueue.dequeue();
    else return null;
  }
}