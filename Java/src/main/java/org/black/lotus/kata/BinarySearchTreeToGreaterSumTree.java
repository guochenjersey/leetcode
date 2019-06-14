package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * */
@LeetCode
@Medium
@Accepted
public class BinarySearchTreeToGreaterSumTree {
    private List<Integer> inOrderRes = new ArrayList<>(100);
    private Map<Integer, Integer> greaterSumMap = new HashMap<>();

    public TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        int sum = inOrderRes.get(inOrderRes.size() - 1);
        greaterSumMap.put(inOrderRes.get(inOrderRes.size() - 1), sum);
        for (int i = inOrderRes.size() - 2; i >= 0; --i) {
            Integer currentVal = inOrderRes.get(i);
            sum += currentVal;
            greaterSumMap.put(currentVal, sum);
        }

        inOrder2(root);

        return root;
    }

    private void inOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder2(root.left);
        root.val = greaterSumMap.get(root.val);
        inOrder2(root.right);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        inOrderRes.add(node.val);
        inOrder(node.right);
    }

    /**
     * Below is the 100% fast solution
     * */
    @org.black.lotus.marker.Solution
    class Solution {
        int sum = 0;
        public TreeNode bstToGst(TreeNode root) {
            recursiveGST(root);
            return root;
        }

        private void recursiveGST(TreeNode root) {
            if(root == null) {
                return ;
            }

            recursiveGST(root.right);
            sum = sum + root.val;
            root.val = sum;
            recursiveGST(root.left);
        }
    }
}
