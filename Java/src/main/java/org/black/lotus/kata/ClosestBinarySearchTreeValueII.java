package org.black.lotus.kata;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Hard;
import org.black.lotus.marker.LintCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are
 * closest to the target.
 *
 * <p>Notice Given target value is a floating point. You may assume k is always valid, that is: k ≤
 * total nodes. You are guaranteed to have only one unique set of k values in the BST that are
 * closest to the target.
 *
 * <p>Example Given root = {1}, target = 0.000000, k = 1, return [1].
 *
 * <p>Challenge Assume that the BST is balanced, could you solve it in less than O(n) runtime (where
 * n = total nodes)?
 *
 * <p>TODO
 */
@FirstRound
@Hard
@LintCode
@Amazon
public class ClosestBinarySearchTreeValueII {

  public List<Integer> closestKValues(TreeNode root, double target, int k) {

    Queue<TreeNode> results =
        new PriorityQueue<>(
            (o1, o2) -> {
              double diff1 = ((double) o1.val) - target;
              double diff2 = ((double) o2.val) - target;
              return (int) (Math.abs(diff1) - Math.abs(diff2));
            });
    return null;
  }
}
