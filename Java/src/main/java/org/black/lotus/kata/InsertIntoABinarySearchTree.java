package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

 Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 For example,

 Given the tree:
 4
 / \
 2   7
 / \
 1   3
 And the value to insert: 5
 You can return this binary search tree:

 4
 /   \
 2     7
 / \   /
 1   3 5
 This tree is also valid:

 5
 /   \
 2     7
 / \
 1   3
 \
 4
 * */
@LeetCode
@Medium
@FirstRound
@Accepted
public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            helper(root.right, val, root);
        } else {
            helper(root.left, val, root);
        }

        return root;
    }

    private void helper(TreeNode node, int val, TreeNode parent) {
        if (node == null) {
            if (val < parent.val) {
                parent.left = new TreeNode(val);
                return;
            } else {
                parent.right = new TreeNode(val);
                return;
            }
        }

        if (node.val < val) {
            helper(node.right, val, node);
        } else {
            helper(node.left, val, node);
        }
    }
}
