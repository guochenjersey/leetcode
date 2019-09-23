package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 */
@LeetCode
@Medium
@Accepted("10%")
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        NodeNum nodeNum = new NodeNum();
        inOrder(root, nodeNum);

        return nodeNum.num;
    }

    private void inOrder(TreeNode node, NodeNum num) {
        if (node == null) {
            return;
        }

        inOrder(node.left, num);
        num.num++;
        inOrder(node.right, num);
    }

    class NodeNum {
        int num;
    }
}
