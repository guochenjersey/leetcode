package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
@LeetCode
@FirstRound
@Medium
public class DeleteANodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root, key);
    }

    private TreeNode helper(TreeNode node, int key) {
        if (node == null) {
            return null;
        }

        if (node.val == key
                && node.right == null
                && node.left == null) {
            return null;
        }

        if (node.val > key) {
            node.left = helper(node.left, key);
        } else {
            node.right = helper(node.right, key);
        }

        // if node value equals to key
        if (node.val == key) {
            if (node.right != null) {
                int val = findMinValInRight(node.right);
                node.val = val;
                node.right = helper(node.right, val);
            } else if (node.left != null) {
                int val = findMaxValInLeft(node.left);
                node.val = val;
                node.left = helper(node.left, val);
            }

        }

        return node;
    }

    private int findMinValInRight(TreeNode node) {
        if (node.left == null)
            return node.val;
        return findMinValInRight(node.left);
    }

    private int findMaxValInLeft(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        return findMaxValInLeft(node.right);
    }
}
