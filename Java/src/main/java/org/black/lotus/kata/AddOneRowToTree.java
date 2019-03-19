package org.black.lotus.kata;

import org.black.lotus.marker.*;
import org.black.lotus.org.black.lotus.support.TreeNode;

/** TODO */
@LeetCode
@FirstRound
@Medium
@Tree
@NotAccepted
public class AddOneRowToTree {

  public AddOneRowToTree() {}

  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (root == null && d != 1) {
      return null;
    }
    if (root == null) {
      return new TreeNode(v);
    }

    d = d - 1;
    if (root.left != null) {
      helper(d, 1, root.left, root, v, true);
    }
    if (root.right != null) {
      helper(d, 1, root.right, root, v, false);
    }

    return root;
  }

  private void helper(
      int desiredDepth,
      int currentDepth,
      TreeNode child,
      TreeNode parent,
      int value,
      boolean leftTree) {
    if (desiredDepth == currentDepth) {
      TreeNode nodeToInsert = new TreeNode(value);
      if (leftTree) {
        parent.left = nodeToInsert;
        nodeToInsert.left = child;
      } else {
        parent.right = nodeToInsert;
        nodeToInsert.right = child;
      }

      return;
    }

    ++currentDepth;

    if (child.left != null) {
      helper(desiredDepth, currentDepth, child.left, child, value, true);
    }
    if (child.right != null) {
      helper(desiredDepth, currentDepth, child.right, child, value, false);
    }
  }
}
