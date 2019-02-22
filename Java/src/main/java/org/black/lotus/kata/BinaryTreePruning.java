package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

 Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

 (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 * */
@LeetCode
@Medium
@FirstRound
@Accepted
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        prune(root);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }

    private void prune(TreeNode node) {
        if (node == null) {
            return;
        }
        if (!contains1(node.left)) {
            node.left = null;
        }

        if (!contains1(node.right)) {
            node.right = null;
        }

        prune(node.left);
        prune(node.right);
    }

    private boolean contains1(TreeNode node) {
        if (node == null) {
            return false;
        }
        return (node.val == 1)
                || contains1(node.left)
                || contains1(node.right);

    }
}
