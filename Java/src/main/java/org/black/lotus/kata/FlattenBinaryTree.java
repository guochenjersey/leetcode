package org.black.lotus.kata;

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
public class FlattenBinaryTree {

    public LinkedList<Integer> flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<Integer> res = new LinkedList<>();
        preOrder(root, res);

        return res;
    }

    private void preOrder(TreeNode node, LinkedList res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

}
