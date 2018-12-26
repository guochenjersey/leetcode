package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.Tree;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 *
 * */
@LeetCode
@FirstRound
@Medium
@Tree
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        return left == null && right == null || left != null
                && right != null && left.val == right.val
                && helper(left.left, right.right) && helper(left.right, right.left);

    }

    public boolean isSymmetricLevelTraverse(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currLevel = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            Integer[] levelNodes = new Integer[(int) Math.pow(2, currLevel)];
            int i = 0;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    levelNodes[i] = null;
                    if (i < levelNodes.length) {
                        ++i;
                    }
                    levelNodes[i] = null;
                    if (i < levelNodes.length) {
                        ++i;
                    }
                    continue;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    levelNodes[i++] = node.left.val;
                } else {
                    queue.offer(null);
                    levelNodes[i++] = null;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    levelNodes[i++] = node.right.val;
                } else {
                    queue.offer(null);
                    levelNodes[i++] = null;
                }

                --size;
            }
            if (!isSymmetricLevelTraverse(levelNodes)) {
                return false;
            }

            if (isNullArray(levelNodes)) {
                return true;
            }
            ++currLevel;
        }

        return true;
    }

    private boolean isSymmetricLevelTraverse(Integer[] nodes) {
        int mid = nodes.length >> 1;
        for (int i = 0, j = nodes.length - 1; i < mid; ++i, --j) {
            if (nodes[i] == null && nodes[j] == null) {
                continue;
            }
            if (nodes[i] == null && nodes[j] != null) {
                return false;
            }

            if (nodes[i] != null && nodes[j] == null) {
                return false;
            }

            if (!nodes[i].equals(nodes[j])) {
                return false;
            }
        }

        return true;
    }

    private boolean isNullArray(Integer[] nums) {
        for (Integer i : nums) {
            if (i != null) {
                return false;
            }
        }

        return true;
    }
}
