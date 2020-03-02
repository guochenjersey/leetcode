package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Hard;
import org.black.lotus.marker.HighFrequency;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 * */
@LeetCode
@Hard
@HighFrequency
@Important
@Accepted
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> res = new LinkedList<>();
        maxRootPathSum(root, res);

        return res.stream().max(Comparator.comparingInt(a -> a)).get();
    }

    private int maxRootPathSum (TreeNode node, List<Integer> paths) {
        if (node == null) {
            return 0;
        }

        int path = node.val;
        int lMax = maxRootPathSum(node.left, paths);
        int rMax = maxRootPathSum(node.right, paths);

        if (lMax > 0) {
            path += lMax;
        }

        if (rMax > 0) {
            path += rMax;
        }

        paths.add(path);

        int max = Math.max(lMax, rMax);
        return node.val + Math.max(max, 0);
    }
}
