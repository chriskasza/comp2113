//----------------------------------------------------------------------------
// BinarySearchTree2.java          by Dale/Joyce/Weems               Chapter 8
//
// Adds a method 'find' to the BinarySearchTree ADT
//----------------------------------------------------------------------------

package ch08.trees;

public class BinarySearchTree2 extends BinarySearchTree
{
  private Comparable recFind(Comparable item, BSTNode tree)
  // Returns reference to tree element that matches item
  // If no match exists, returns null
  {
    if (tree == null)
      return null;                            // item is not found
    else if (item.compareTo(tree.info) < 0)
      return recFind(item, tree.left);        // Search left subtree
    else if (item.compareTo(tree.info) > 0)
      return recFind(item, tree.right);       // Search right subtree
    else
      return tree.info;                       // item is found
  }

  public Comparable find (Comparable item)
  // Returns reference to this tree's element that matches item
  // If no match exists, returns null
  {
    return recFind(item, root);
  }
}