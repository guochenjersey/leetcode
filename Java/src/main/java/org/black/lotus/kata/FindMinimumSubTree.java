package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;

public class FindMinimumSubTree {

  private int subTreeSum = Integer.MAX_VALUE;

  private TreeNode miniumSumTreeNode;

  public TreeNode findMinimumSubTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    subTreeSum(root);
    return miniumSumTreeNode;
  }


  private int subTreeSum(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int sum = subTreeSum(node.left) + subTreeSum(node.right) + node.val;
    if (sum < subTreeSum) {
      subTreeSum = sum;
      miniumSumTreeNode = node;
    }

    return sum;
  }
}
