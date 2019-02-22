package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumBinaryTreeTest {

    @Test
    public void should_find_maximum_binary_tree() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        TreeNode root = maximumBinaryTree.constructMaximumBinaryTree(nums);

        assertEquals(6, root.val);
    }
}