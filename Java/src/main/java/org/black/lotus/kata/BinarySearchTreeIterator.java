package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.Tree;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

@LeetCode
@Medium
@Tree
@Accepted
public class BinarySearchTreeIterator {
    private List<TreeNode> nodes;

    public BinarySearchTreeIterator(TreeNode root) {
        nodes = new ArrayList<>();
        inOrder(root, nodes);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode remove = nodes.remove(0);
        return remove.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    private void inOrder(TreeNode node, List<TreeNode> nodeList) {
        if (node == null) {
            return;
        }

        inOrder(node.left, nodeList);
        nodeList.add(node);
        inOrder(node.right, nodeList);
    }
}
