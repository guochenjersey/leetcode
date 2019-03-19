package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of
 * an array. Example 1: Input: 3 / \ 9 20 / \ 15 7 Output: [3, 14.5, 11] Explanation: The average
 * value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5,
 * 11].
 */
@LeetCode
@FirstRound
@Easy
public class AverageOfLevelsInBinaryTree {

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      int counter = size;
      long sum = 0; // pay attention to the long here.
      while (size != 0) {
        TreeNode node = queue.poll();
        sum += node.val;
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        --size;
      }
      res.add((double) sum / counter);
    }

    return res;
  }
}
