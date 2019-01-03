package org.black.lotus.kata;


import org.black.lotus.marker.*;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, determine if it is a complete binary tree.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 */
@LeetCode
@FirstRound
@Medium
@Important
@NoIdeaOrBadIdeaInitially
public class CheckCompletenessOfBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        int nodesNum = countNodes(root);
        return isComplete(root, 1, nodesNum);
    }

    int countNodes(TreeNode root) {
        if (root == null)
            return (0);
        return (1 + countNodes(root.left) + countNodes(root.right));
    }

    /* This function checks if the binary tree is complete or not */
    boolean isComplete(TreeNode root, int index, int number_nodes) {
        // An empty tree is complete
        if (root == null)
            return true;

        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if (index > number_nodes)
            return false;

        // Recur for left and right subtrees
        return (isComplete(root.left, 2 * index, number_nodes)
                && isComplete(root.right, 2 * index + 1, number_nodes));

    }
}
