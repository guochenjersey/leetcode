package org.black.lotus;

import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Binary Tree Inorder Traversal
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Kata94 {

    /**
     * In order -> left, root, right
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                stack.push(root.right);
            }
        }

        return res;
    }
}
