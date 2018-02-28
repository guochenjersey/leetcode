package org.black.lotus.kata;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode r) {
    if (r == null) {
      return null;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(r);
    while (!queue.isEmpty()) {
      TreeNode t = queue.poll();
      TreeNode temp = t.left;
      t.left = t.right;
      t.right = temp;
      if (t.left != null) {
        queue.offer(t.left);
      }
      if (t.right != null) {
        queue.offer(t.right);
      }
    }
    return r;
  }
}
