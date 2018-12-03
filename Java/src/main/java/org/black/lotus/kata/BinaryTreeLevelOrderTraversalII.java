package org.black.lotus.kata;

import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Description
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 Have you met this question in a real interview?
 Example
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7


 return its bottom-up level order traversal as:

 [
 [15,7],
 [9,20],
 [3]
 ]
 * */
@LintCode
@Medium
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelOrder = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                levelOrder.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                --size;
            }
            result.addFirst(levelOrder);
        }

        return result;
    }
}
