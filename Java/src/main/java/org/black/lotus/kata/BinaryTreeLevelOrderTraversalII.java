package org.black.lotus.kata;

import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
