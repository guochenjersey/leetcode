package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NotAccepted;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output:
 * <p>
 * 2
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output:
 * <p>
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 * TODO to check how it works
 */
@LeetCode
@Easy
@NotAccepted
public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        return traverse(root, new HashSet<>(), 0);
    }

    private int traverse(TreeNode node, Set<Integer> vals, int maxPath) {
        if (node == null) {
            return maxPath;
        }
        if (!vals.contains(node.val)) {
            vals.add(node.val);
        } else {
            vals = new HashSet<>();
            vals.add(node.val);
        }

        maxPath = Math.max(vals.size(), maxPath);
        return Math.max(traverse(node.left, vals, maxPath), traverse(node.right, vals, maxPath));
    }
}
