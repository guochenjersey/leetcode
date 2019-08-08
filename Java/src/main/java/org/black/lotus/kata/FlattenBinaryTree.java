package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.LinkedList;

/**
 *
 *    1
 *   / \
 *  2   5
 * / \   \
 *3   4   6
 *
 * 1 ->2 ->3 -> 4 -> 5 -> 6
 * */
@LeetCode
@Medium
@FirstRound
@Accepted
public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<Integer> nodes = new LinkedList<>();
        preOrder(root, nodes);
        TreeNode prev = root;
        for(Integer i : nodes) {
            if (root == null) {
                root = new TreeNode(i);
                prev.right = root;
            } else {
                root.left = null;
                root.val = i;
            }
            prev = root;
            root = root.right;
        }
    }

    private void preOrder(TreeNode root, LinkedList<Integer> nodes) {
        if (root == null) {
            return;
        }

        nodes.add(root.val);
        preOrder(root.left, nodes);
        preOrder(root.right, nodes);
    }

}
