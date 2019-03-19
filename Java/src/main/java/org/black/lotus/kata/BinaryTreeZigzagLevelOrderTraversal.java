package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

@LeetCode
@FirstRound
@Medium
public class BinaryTreeZigzagLevelOrderTraversal {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    Deque<TreeNode> nodes = new ArrayDeque<>();
    int level = 0;
    List<List<Integer>> res = new ArrayList<>();
    nodes.offerLast(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      List<Integer> levelNodes = new ArrayList<>();
      while (size != 0) {
        TreeNode node = nodes.pollFirst();
        if (node.left != null) {
          nodes.offerLast(node.left);
        }
        if (node.right != null) {
          nodes.offerLast(node.right);
        }

        if (level % 2 == 0) {
          levelNodes.add(node.val);
        } else {
          levelNodes.add(0, node.val);
        }

        --size;
      }
      res.add(levelNodes);
      ++level;
    }

    return res;
  }
}
