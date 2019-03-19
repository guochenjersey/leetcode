package org.black.lotus.kata;

import java.util.HashSet;
import java.util.Set;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value
 * between L and R (inclusive).
 *
 * <p>The binary search tree is guaranteed to have unique values.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 Output: 32 Example 2:
 *
 * <p>Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10 Output: 23
 *
 * <p>Note:
 *
 * <p>The number of nodes in the tree is at most 10000. The final answer is guaranteed to be less
 * than 2^31.
 */
@LeetCode
@FirstRound
@Medium
public class RangeSumOfBST {

  public int rangeSumBST(TreeNode root, int L, int R) {
    L = Math.min(L, R);
    R = Math.max(L, R);

    Set<Integer> resSet = new HashSet<>();
    helper(root, L, R, resSet);

    return resSet.stream().mapToInt(i -> i).sum();
  }

  private void helper(TreeNode node, int L, int R, Set<Integer> resSet) {
    if (node == null) {
      return;
    }

    if (node.val >= L && node.val <= R) {
      resSet.add(node.val);
    }

    if (node.val > R) {
      helper(node.left, L, R, resSet);
      return;
    }

    if (node.val < L) {
      helper(node.right, L, R, resSet);
      return;
    }

    helper(node.left, L, R, resSet);
    helper(node.right, L, R, resSet);
  }
}
