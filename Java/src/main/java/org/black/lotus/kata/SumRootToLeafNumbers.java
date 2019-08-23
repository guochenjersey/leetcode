package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.Tree;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * */
@LeetCode
@Medium
@Accepted
@Tree
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        List<Integer> paths = new ArrayList<>();
        helper(root, 0, paths);
        return paths.stream().mapToInt(Integer::intValue).sum();
    }

    private void helper(TreeNode node, int val, List<Integer> paths) {
        if (node == null) {
            return;
        }

        val = val * 10 + node.val;
        // 注意这个地方要判断叶子节点
        if (node.left == null && node.right == null) {
            paths.add(val);
            return;
        }

        helper(node.left, val, paths);
        helper(node.right, val, paths);
    }
}
