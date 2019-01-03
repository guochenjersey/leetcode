package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 */
@LeetCode
@Easy
@FirstRound
public class MiniumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, 0);
    }

    private int helper(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        ++level;
        if (node.left == null && node.right == null) {
            return level;
        }

        if (node.left == null) {
            return helper(node.right, level);
        }

        if (node.right == null) {
            return helper(node.left, level);
        }

        return Math.min(helper(node.left, level),
                helper(node.right, level));
    }
}
