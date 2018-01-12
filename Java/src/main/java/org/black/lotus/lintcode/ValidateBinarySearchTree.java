package org.black.lotus.lintcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    List<TreeNode> res = new LinkedList<>();
    inOrder(root, res);
    return isAscending(res);
  }

  private void inOrder(TreeNode node, List<TreeNode> res) {
    if (node == null) {
      return;
    }

    inOrder(node.left, res);
    res.add(node);
    inOrder(node.right, res);
  }

  private boolean isAscending(List<TreeNode> treeNodes) {
    Iterator<TreeNode> iterator = treeNodes.iterator();
    TreeNode prev = null;
    while (iterator.hasNext()) {
      TreeNode node = iterator.next();
      if (prev == null) {
        prev = node;
      } else {
        if (prev.val >= node.val) {
          return false;
        }
        prev = node;
      }
    }

    return true;
  }
}
