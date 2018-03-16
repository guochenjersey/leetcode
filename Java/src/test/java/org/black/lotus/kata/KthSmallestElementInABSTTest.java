package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthSmallestElementInABSTTest {

    @Test
    public void should_find_kth_smallest() {
        KthSmallestElementInABST solution = new KthSmallestElementInABST();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        solution.kthSmallest(root, 1);
    }
}