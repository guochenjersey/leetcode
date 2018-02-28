package org.black.lotus.kata;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    preOrder(root, res);
    return res;
  }

  private void preOrder(TreeNode node, List<Integer> res) {
    if (node == null) {
      return;
    }

    res.add(node.val);
    preOrder(node.left, res);
    preOrder(node.right, res);
  }

}
