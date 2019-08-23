package org.black.lotus.kata;

import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.NotAccepted;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@LeetCode
@Medium
@NotAccepted
@NoIdeaOrBadIdeaInitially
public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        int level = nodes.size();
        int maxWidth = 1;
        while(!nodes.isEmpty()) {
            int counter = 0;
            List<TreeNode> levelNodes = new ArrayList<>(2 * level);
            while (level > 0) {
                TreeNode node = nodes.poll();
                if (node != null && node.left != null) {
                    nodes.offer(node.left);
                } else {
                    nodes.offer(null);
                }
                if (node != null && node.right != null) {
                    nodes.offer(node.right);
                } else {
                    nodes.offer(null);
                }
                counter += 2;

                --level;
            }
            levelNodes.addAll(nodes);

            level = counter;
            maxWidth = Math.max(maxWidth, helper(levelNodes));
        }

        return maxWidth;
    }

    private int helper(List<TreeNode> nodes) {
        for (int i = 0, j = nodes.size() - 1; i <= j; ) {
            if (nodes.get(i) == null) {
                ++i;
                continue;
            }

            if (nodes.get(j) == null) {
                --j;
                continue;
            }

            return j - i + 1;
        }

        return 0;
    }

}
