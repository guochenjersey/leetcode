package org.black.lotus.kata;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

  public static int getTreeNodeNum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> treeNodes = new LinkedList<>();
    int tradeNodeCounter = 1;
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      TreeNode head = treeNodes.remove();
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

class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(){};
    public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}