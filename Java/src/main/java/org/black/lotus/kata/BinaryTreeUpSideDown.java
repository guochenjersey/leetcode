package org.black.lotus.kata;

import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.Tree;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * <p>
 * Example
 * Example1
 * <p>
 * Input: {1,2,3,4,5}
 * Output: {4,5,2,#,#,3,1}
 * Explanation:
 * The input is
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * and the output is
 *    4
 *   / \
 *  5   2
 * / \
 *3   1
 */
@LintCode
@LeetCode
@Medium
@Tree
@NoIdeaOrBadIdeaInitially
public class BinaryTreeUpSideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        return null;
    }
}
