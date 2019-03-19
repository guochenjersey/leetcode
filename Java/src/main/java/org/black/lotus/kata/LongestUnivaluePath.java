package org.black.lotus.kata;

import org.black.lotus.marker.*;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same
 * value. This path may or may not pass through the root.
 *
 * <p>Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * <p>Example 1:
 *
 * <p>Input:
 *
 * <p>5 / \ 4 5 / \ \ 1 1 5 Output:
 *
 * <p>2 Example 2:
 *
 * <p>Input:
 *
 * <p>1 / \ 4 5 / \ \ 4 4 5 Output:
 *
 * <p>2 Note: The given binary tree has not more than 10000 nodes. The height of the tree is not
 * more than 1000. TODO to check how it works
 */
@LeetCode
@Easy
@NoIdeaOrBadIdeaInitially
@Accepted
@Important
@Tree
public class LongestUnivaluePath {
  // Global max
  private int max;

  public int longestUnivaluePath(TreeNode root) {
    max = 0;
    longestPath(root);
    return max;
  }

  public int longestPath(TreeNode node) {
    // Base case: if null node, return 0
    if (node == null) {
      return 0;
    }
    // Get the max length from left and right
    int maxLeft = longestPath(node.left);
    int maxRight = longestPath(node.right);
    // Calculate the current max length
    int maxLeftSoFar = 0;
    int maxRightSoFar = 0;
    // Compare parent node with child node
    // If they are the same, extend the max length by one
    if (node.left != null && node.left.val == node.val) {
      maxLeftSoFar = maxLeft + 1;
    }
    if (node.right != null && node.right.val == node.val) {
      maxRightSoFar = maxRight + 1;
    }
    // Update the max with the sum of left and right length
    max = Math.max(max, maxLeftSoFar + maxRightSoFar);
    // Return the max from left and right to upper node
    // since only one side path is valid, 最底下这行有点没看懂.
    return Math.max(maxLeftSoFar, maxRightSoFar);
  }
}
