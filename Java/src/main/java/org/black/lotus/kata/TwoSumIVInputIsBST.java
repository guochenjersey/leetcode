package org.black.lotus.kata;

import java.util.HashSet;
import java.util.Set;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the
 * BST such that their sum is equal to the given target.
 *
 * <p>Example 1:
 *
 * <p>Input: 5 / \ 3 6 / \ \ 2 4 7
 *
 * <p>Target = 9
 *
 * <p>Output: True
 */
@LeetCode
@Easy
@Important
@FirstRound
public class TwoSumIVInputIsBST {

  public boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }

    Set<Integer> set = new HashSet<>();
    inOrder(root, set);
    for (int i : set) {
      if (set.contains(k - i) && (k - i) != i) {
        return true;
      }
    }

    return false;
  }

  private void inOrder(TreeNode node, Set<Integer> set) {
    if (node == null) {
      return;
    }

    inOrder(node.left, set);
    set.add(node.val);
    inOrder(node.right, set);
  }
}
