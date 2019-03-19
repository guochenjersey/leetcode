package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Facebook;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

@LeetCode
@Medium
@Accepted
@Facebook
public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerFirst(root);
    TreeNode node;
    while (!deque.isEmpty()) {
      int levelSize = deque.size();
      int count = 1;
      while (levelSize > 0) {
        node = deque.pollLast();
        if (count == 1) {
          res.add(node.val);
          count = 0;
        }
        --levelSize;
        if (node.right != null) {
          deque.offerFirst(node.right);
        }
        if (node.left != null) {
          deque.offerFirst(node.left);
        }
      }
    }

    return res;
  }
}
