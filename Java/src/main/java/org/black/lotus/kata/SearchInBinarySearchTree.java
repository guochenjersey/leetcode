package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the
 * BST that the node's value equals the given value. Return the subtree rooted with that node. If
 * such node doesn't exist, you should return NULL.
 *
 * <p>For example,
 *
 * <p>Given the tree: 4 / \ 2 7 / \ 1 3
 *
 * <p>And the value to search: 2 You should return this subtree:
 *
 * <p>2 / \ 1 3 In the example above, if we want to search the value 5, since there is no node with
 * value 5, we should return NULL.
 *
 * <p>Note that an empty tree is represented by NULL, therefore you would see the expected output
 * (serialized tree format) as [], not null.
 */
@LeetCode
@Easy
@FirstRound
public class SearchInBinarySearchTree {

  public TreeNode searchBST(TreeNode root, int val) {
    Res res = new Res();
    helper(root, res, val);
    return res.node;
  }

  private void helper(TreeNode root, Res res, int val) {
    if (root == null) {
      return;
    }

    if (root.val == val) {
      res.node = root;
      return;
    }

    if (root.val < val) {
      helper(root.right, res, val);
    } else {
      helper(root.left, res, val);
    }
  }

  class Res {
    TreeNode node;
  }
}
