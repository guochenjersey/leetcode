package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

@LeetCode
@Easy
public class DiameterOfBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxPath(root);

        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = helper(node.left) + 1;
        int rightMax = helper(node.left) + 1;

        return Math.max(leftMax, rightMax);
    }

    private void maxPath(TreeNode node) {
        if (node == null) {
            return;
        }

        int leftMax = helper(node.left);
        int rightMax = helper(node.right);

        int diameterOfNode = leftMax + rightMax;

        max = Math.max(max, diameterOfNode);

        maxPath(node.left);
        maxPath(node.right);
    }
}
