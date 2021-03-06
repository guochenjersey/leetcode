package org.black.lotus.kata;

import org.black.lotus.marker.*;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * <p>For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 *
 * <p>Example:
 *
 * <p>Given the sorted array: [-10,-3,0,5,9],
 *
 * <p>One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced
 * BST:
 *
 * <p>0 / \ -3 9 / / -10 5
 */
@LeetCode
@Easy
@FirstRound
@BinarySearch
@Important
@Accepted
public class ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    return create(nums, 0, nums.length - 1);
  }

  private TreeNode create(int[] nums, int start, int end) {
    if (start < 0 || end >= nums.length || start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = create(nums, start, mid - 1);
    node.right = create(nums, mid + 1, end);

    return node;
  }
}
