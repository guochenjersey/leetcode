package org.black.lotus.kata;

import org.black.lotus.marker.Tree;
import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumWidthOfBinaryTreeTest {

    @Test
    public void should_find_max_width() {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(3);
        TreeNode rootRight = new TreeNode(2);

        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(5);
        TreeNode rootleftRight = new TreeNode(3);

        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootleftRight;

        rootRight.right = new TreeNode(9);

        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();

        int res = maximumWidthOfBinaryTree.widthOfBinaryTree(root);

        assertEquals(4, res);
    }

    @Test
    public void should_find_max_width_2() {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(3);
        root.left = rootLeft;
        root.right = new TreeNode(2);
        rootLeft.left = new TreeNode(5);

        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        int res = maximumWidthOfBinaryTree.widthOfBinaryTree(root);
        assertEquals(2, res);
    }

    @Test
    public void should_find_max_width_3() {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootRight = new TreeNode(1);

        root.left = rootLeft;
        root.right = rootRight;

    }
}