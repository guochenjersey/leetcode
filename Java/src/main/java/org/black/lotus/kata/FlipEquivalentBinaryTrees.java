package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the
 * left and right child subtrees.
 *
 * <p>A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y
 * after some number of flip operations.
 *
 * <p>Write a function that determines whether two binary trees are flip equivalent. The trees are
 * given by root nodes root1 and root2.
 *
 * <p>Example 1:
 *
 * <p>Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 =
 * [1,3,2,null,6,4,5,null,null,null,null,8,7] Output: true Explanation: We flipped at nodes with
 * values 1, 3, and 5. Flipped Trees Diagram
 *
 * <p>Note:
 *
 * <p>Each tree will have at most 100 nodes. Each value in each tree will be a unique integer in the
 * range [0, 99].
 */
@LeetCode
@Medium
@FirstRound
public class FlipEquivalentBinaryTrees {

  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    return isEquivNode(root1, root2);
  }

  private boolean isEquivNode(TreeNode node1, TreeNode node2) {
    boolean sameNode = isSameNode(node1, node2);
    if (!sameNode) {
      return false;
    }
    if (node1 == null && node2 == null) {
      return true;
    }
    boolean sameLeft = isSameNode(node1.left, node2.left);
    boolean sameRight = isSameNode(node1.right, node2.right);

    if (sameLeft && sameRight) {
      return isEquivNode(node1.left, node2.left) && isEquivNode(node1.right, node2.right);
    }

    swap(node1);
    boolean res = isSameNode(node1.left, node2.left) && isSameNode(node1.right, node2.right);
    if (!res) {
      return false;
    }

    return isEquivNode(node1.left, node2.left) && isEquivNode(node1.right, node2.right);
  }

  private void swap(TreeNode node) {
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
  }

  private boolean isSameNode(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }

    if (node1 != null && node2 == null) {
      return false;
    }

    if (node1 == null && node2 != null) {
      return false;
    }

    if (node1.val != node2.val) {
      return false;
    }

    return true;
  }
}
