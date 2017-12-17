package org.black.lotus;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.black.lotus.org.black.lotus.support.TreeNode;

public class Kata144 {

  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> treeNodeStack = new Stack<>();
    treeNodeStack.push(root);
    while (!treeNodeStack.isEmpty()) {
      TreeNode currentNode = treeNodeStack.pop();
      result.add(currentNode.val);
      if (currentNode.right != null) {
        treeNodeStack.push(currentNode.right);
      }

      if (currentNode.left != null) {
        treeNodeStack.push(currentNode.left);
      }
    }

    return result;
  }
}
