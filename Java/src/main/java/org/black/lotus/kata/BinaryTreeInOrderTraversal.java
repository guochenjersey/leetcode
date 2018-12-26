package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    helper(root, res);
    return res;
  }

  private void helper(TreeNode node, List<Integer> path) {
    if (node == null) {
      return;
    }

    helper(node.left, path);
    path.add(node.val);
    helper(node.right, path);
  }
}
