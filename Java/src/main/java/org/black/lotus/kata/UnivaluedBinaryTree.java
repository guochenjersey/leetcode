package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * <p>Return true if and only if the given tree is univalued.
 *
 * <p>
 *
 * <p>
 *
 * <p>Example 1:
 *
 * <p>
 *
 * <p>Input: [1,1,1,1,1,null,1] Output: true Example 2:
 *
 * <p>
 *
 * <p>Input: [2,2,2,5,2] Output: false
 *
 * <p>
 *
 * <p>Note:
 *
 * <p>The number of nodes in the given tree will be in the range [1, 100]. Each node's value will be
 * an integer in the range [0, 99]. Accepted
 */
@LeetCode
@Easy
@Accepted
public class UnivaluedBinaryTree {

  public boolean isUnivalTree(TreeNode root) {
    if (root == null) {
      return true;
    }
    int val = root.val;
    MutableObj res = new MutableObj();
    res.res = true;
    preOrder(root, val, res);
    return res.res;
  }

  private void preOrder(TreeNode root, int val, MutableObj res) {
    if (root == null || !res.res) {
      return;
    }

    if (root.val != val) {
      res.res = false;
      return;
    }

    preOrder(root.left, val, res);
    preOrder(root.right, val, res);
  }

  class MutableObj {
    boolean res;
  }
}
