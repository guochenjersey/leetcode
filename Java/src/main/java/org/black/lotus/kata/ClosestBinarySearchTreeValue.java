package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is
 * closest to the target.
 *
 * <p>Notice Given target value is a floating point. You are guaranteed to have only one unique
 * value in the BST that is closest to the target.
 *
 * <p>Example Given root = {1}, target = 4.428571, return 1.
 *
 * <p>相当于查找BST中在某两个节点中间.如果要是INORDER的话复杂度是O(N),这个查找节点的方法是O(H)的复杂度.
 */
@FirstRound
@LintCode
@Easy
@Important
public class ClosestBinarySearchTreeValue {

  public int closestValue(TreeNode root, double target) {
    if (root == null) {
      return 0;
    }
    TreeNode lowerNode = findLowerBound(root, target);
    TreeNode upperNode = findUpperBound(root, target);

    if (lowerNode == null) {
      return upperNode.val;
    }

    if (upperNode == null) {
      return lowerNode.val;
    }

    if (target - lowerNode.val > upperNode.val - target) {
      return upperNode.val;
    }

    return lowerNode.val;
  }

  private TreeNode findUpperBound(TreeNode root, double target) {
    if (root == null) {
      return null;
    }

    if (root.val < target) {
      return findUpperBound(root.right, target);
    }

    // root.val >= target
    TreeNode upperNode = findUpperBound(root.left, target);
    if (upperNode != null) {
      return upperNode;
    }

    return root;
  }

  private TreeNode findLowerBound(TreeNode root, double target) {
    if (root == null) {
      return null;
    }

    if (target <= root.val) {
      return findLowerBound(root.left, target);
    }

    TreeNode node = findLowerBound(root.right, target);
    if (node != null) {
      return node;
    }

    return root;
  }
}
