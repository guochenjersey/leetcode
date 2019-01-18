package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Tree;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 Note: A leaf is a node with no children.

 Example:

 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


 * */
@LeetCode
@Easy
@Tree
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, 0, sum);
    }

    private boolean helper(TreeNode node, int sum, int target) {
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum == target;
        }
        boolean isLeftHasPathSum = false;
        boolean isRightHasPathSum = false;

        if (node.left != null) {
            isLeftHasPathSum = helper(node.left, sum, target);
        }

        if (node.right != null) {
            isRightHasPathSum = helper(node.right, sum, target);
        }

        return isLeftHasPathSum || isRightHasPathSum;
    }
}
