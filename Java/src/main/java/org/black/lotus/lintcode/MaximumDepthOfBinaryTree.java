package org.black.lotus.lintcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfBinaryTree {
  /**
   * @param root: The root of binary tree.
   * @return: An integer.
   */
  public int maxDepth(TreeNode root) {
    return traverseByLevel(root);
  }

  private int helper(TreeNode node, int height) {
    if (node == null) {
      return height;
    }

    int leftTreeDepth = helper(node.left, height + 1);
    int rightTreeDepth = helper(node.right, height + 1);

    return Math.max(leftTreeDepth, rightTreeDepth);
  }

  private int traverseByLevel(TreeNode node) {
    if (node == null) {
      return 0;
    }
    Deque<TreeNode> nodes = new ArrayDeque<>();
    nodes.offerFirst(node);
    return traverseByLevelHelper(nodes);
  }

  private int traverseByLevelHelper(Deque<TreeNode> deque) {
    int treeHeight = 0;
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size ; ++i) {
        TreeNode node = deque.pollFirst();
        if (node.left != null) {
          deque.offerLast(node.left);
        }
        if (node.right != null) {
          deque.offerLast(node.right);
        }
      }
      treeHeight++;
    }

    return treeHeight;
  }
}
