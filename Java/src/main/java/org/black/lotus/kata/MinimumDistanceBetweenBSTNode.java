package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * Example :
 * <p>
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * <p>
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * Note:
 * <p>
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 */
@LeetCode
@Easy
@FirstRound
public class MinimumDistanceBetweenBSTNode {

    public int minDiffInBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size(); ++i) {
            if (i + 1 < nodes.size()) {
                min = Math.min(Math.abs(nodes.get(i) - nodes.get(i + 1)), min);
            }
        }

        return min;
    }

    private void inOrder(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        inOrder(node.left, nodes);
        nodes.add(node.val);
        inOrder(node.right, nodes);
    }
}
