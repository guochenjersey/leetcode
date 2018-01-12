package org.black.lotus.lintcode;

public class MaximumDepthOfBinaryTree {
  /**
   * @param root: The root of binary tree.
   * @return: An integer.
   */
  public int maxDepth(TreeNode root) {
    return helper(root, 0);
  }

  private int helper(TreeNode node, int height) {
    if (node == null) {
      return height;
    }

    int leftTreeDepth = helper(node.left, height + 1);
    int rightTreeDepth = helper(node.right, height + 1);

    return Math.max(leftTreeDepth, rightTreeDepth);
  }
}
