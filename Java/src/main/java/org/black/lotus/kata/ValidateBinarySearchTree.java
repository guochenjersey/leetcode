package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.NotAccepted;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 A single node tree is a BST
 Have you met this question in a real interview?
 Example
 An example:

 2
 / \
 1   4
 / \
 3   5
 The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).


 *
 *
 *
 * */

@FirstRound
@LintCode
@NoIdeaOrBadIdeaInitially
@NotAccepted
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
