package org.black.lotus.lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

  public static <T> int getTreeNodeNum(TreeNode<T> root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode<T>> treeNodes = new LinkedList<>();
    int tradeNodeCounter = 1;
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      TreeNode<T> head = treeNodes.remove();
      if (head.left != null) {
        treeNodes.add(head.left);
        ++tradeNodeCounter;
      }

      if (head.right != null) {
        treeNodes.add(head.right);
        ++tradeNodeCounter;
      }
    }

    return tradeNodeCounter;
  }
}

class TreeNode<T> {
  T val;
  TreeNode<T> left;
  TreeNode<T> right;
}