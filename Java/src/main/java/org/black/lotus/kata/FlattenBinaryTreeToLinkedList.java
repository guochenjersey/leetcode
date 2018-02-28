package org.black.lotus.kata;

public class FlattenBinaryTreeToLinkedList {

  public void flatten(TreeNode root) {
    helper(root);
  }

  private void helper(TreeNode node) {
    if (node == null) {
      return;
    }

    if (node.left != null) {
      TreeNode temp = node.right;
      node.right = node.left;
      helper(node.left);
      node.right.right = temp;
      node.left = null;
      helper(temp);
    } else {
      helper(node.right);
    }
  }
}
