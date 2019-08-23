package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.Tree;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 *
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 *
 * (As a reminder, any shorter prefix of a string is
 * lexicographically smaller:
 * for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 *
 *
 * */
@LeetCode
@Medium
@Tree
@Accepted
public class SmallestStringStartingFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        String path = "";
        return helper(root, path, null);
    }

    private String helper(TreeNode node, String path, String min) {
        if (node == null) {
            return min;
        }

        char c = (char) ('a' + node.val);
        path = c + path;
        if (node.left == null && node.right == null) {
            if (min == null) {
                return path;
            }
            min = path.compareTo(min) < 0 ? path : min;
            return min;
        }

        String lmin = helper(node.left, path, min);
        String rmin = helper(node.right, path, min);
        if (lmin == null) {
            return rmin;
        }
        if (rmin == null) {
            return lmin;
        }
        return lmin.compareTo(rmin) < 0 ? lmin : rmin;
    }
}
