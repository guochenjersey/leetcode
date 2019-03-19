package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given
 * sum.
 *
 * <p>Note: A leaf is a node with no children.
 *
 * <p>Example:
 *
 * <p>Given the below binary tree and sum = 22,
 *
 * <p>5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1 Return:
 *
 * <p>[ [5,4,11,2], [5,8,4,5] ]
 */
@LeetCode
@Medium
@FirstRound
@Accepted
public class PathSumII {

  // accepted but very slow
  public List<List<Integer>> pathSum(TreeNode root, int target) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    helper(root, path, res, target);
    return res;
  }

  private void helper(TreeNode node, List<Integer> path, List<List<Integer>> res, int target) {
    path.add(node.val);
    if (node.left == null && node.right == null) {
      if (path.stream().mapToInt(i -> i).sum() == target) {
        res.add(path);
      }
      return;
    }

    if (node.left != null) {
      List<Integer> leftPathCopy = new ArrayList<>(path);
      helper(node.left, leftPathCopy, res, target);
    }

    if (node.right != null) {
      List<Integer> rightPathCopy = new ArrayList<>(path);
      helper(node.right, rightPathCopy, res, target);
    }
  }
}
