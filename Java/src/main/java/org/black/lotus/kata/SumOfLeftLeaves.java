package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Tree;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
@LeetCode
@Easy
@FirstRound
@Tree
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<NodeWrapper> nodes = new LinkedList<>();
        nodes.offer(new NodeWrapper(root, false));
        int sum = 0;
        while (!nodes.isEmpty()) {
            NodeWrapper nodeWrapper = nodes.poll();
            if (nodeWrapper.node.left == null
                    && nodeWrapper.node.right == null
                    && nodeWrapper.isLeft) {
                sum += nodeWrapper.node.val;
            }

            if (nodeWrapper.node.left != null) {
                nodes.offer(new NodeWrapper(nodeWrapper.node.left, true));
            }

            if (nodeWrapper.node.right != null) {
                nodes.offer(new NodeWrapper(nodeWrapper.node.right, false));
            }
        }

        return sum;
    }

    class NodeWrapper {
        TreeNode node;
        boolean isLeft;

        NodeWrapper(TreeNode node, boolean isLeft) {
            this.node = node;
            this.isLeft = isLeft;
        }
    }
}
