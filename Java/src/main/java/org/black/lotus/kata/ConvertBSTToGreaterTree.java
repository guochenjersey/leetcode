package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the
 * original BST is changed to the original key plus sum of all keys greater than the original key in
 * BST.
 *
 * <p>Example:
 *
 * <p>Input: The root of a Binary Search Tree like this: 5 / \ 2 13
 *
 * <p>Output: The root of a Greater Tree like this: 18 / \ 20 13
 */
@LeetCode
@Easy
@FirstRound
public class ConvertBSTToGreaterTree {

  private int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    post(root);
    return root;
  }

  public void post(TreeNode current) {
    if (current != null) {
      post(current.right);
      current.val += sum;
      sum = current.val;
      post(current.left);
    }
  }

  private TreeNode slowMethod(TreeNode root) {
    TreeSet<Integer> set = new TreeSet<>();
    inOrder(root, set);
    inOrder2(root, set);

    return root;
  }

  private void inOrder(TreeNode root, TreeSet<Integer> list) {
    if (root == null) {
      return;
    }
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }

  private void inOrder2(TreeNode root, TreeSet<Integer> set) {
    if (root == null) {
      return;
    }

    inOrder2(root.left, set);
    root.val = set.tailSet(root.val).stream().mapToInt(i -> i).sum();
    inOrder2(root.right, set);
  }
}
