package org.black.lotus.kata;

import org.black.lotus.marker.*;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as
 * follow:
 *
 * <p>The root is the maximum number in the array. The left subtree is the maximum tree constructed
 * from left part subarray divided by the maximum number. The right subtree is the maximum tree
 * constructed from right part subarray divided by the maximum number. Construct the maximum tree by
 * the given array and output the root node of this tree.
 *
 * <p>Example 1: Input: [3,2,1,6,0,5] Output: return the tree root node representing the following
 * tree:
 *
 * <p>6 / \ 3 5 \ / 2 0 \ 1
 */
@LeetCode
@Medium
@FirstRound
@Accepted
@Tree
public class MaximumBinaryTree {

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int idx = findMax(nums, start, end);
    TreeNode node = new TreeNode(nums[idx]);
    node.left = helper(nums, start, idx - 1);
    node.right = helper(nums, idx + 1, end);

    return node;
  }

  private int findMax(int[] nums, int start, int end) {
    int max = nums[start];
    int idx = start;
    for (int i = start + 1; i <= end; ++i) {
      if (nums[i] > max) {
        idx = i;
        max = nums[i];
      }
    }

    return idx;
  }
}
