package org.black.lotus.kata;

import org.black.lotus.marker.*;
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
@LeetCode
@NoIdeaOrBadIdeaInitially
@Important
@Accepted
public class ValidateBinarySearchTree {

  public boolean isValidBST(TreeNode root) {
      return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

    private boolean isValid(TreeNode node, long min , long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }

        if (node.left != null && node.left.val >= node.val) {
            return false;
        }

        if (node.right != null && node.right.val <= node.val) {
            return false;
        }

        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

}
