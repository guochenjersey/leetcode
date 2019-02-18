package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
@LeetCode
@Easy
@FirstRound
@Accepted
public class PathSumIII {

    public int pathSum(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        NumberHolder res = new NumberHolder();
        inOrder(root, target, res);

        return res.i;
    }

    private void inOrder(TreeNode node, int target, NumberHolder res) {
        if (node == null)
            return;
        inOrder(node.left, target, res);
        helper(node, target, 0, res);
        inOrder(node.right, target, res);
    }


    private void helper(TreeNode node,
                        int target,
                        int sum,
                        NumberHolder res) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (sum == target) {
            res.i++;
        }

        if (node.left != null) {
            helper(node.left, target, sum, res);
        }

        if (node.right != null) {
            helper(node.right, target, sum, res);
        }
    }

    class NumberHolder {
        int i;
    }
}
