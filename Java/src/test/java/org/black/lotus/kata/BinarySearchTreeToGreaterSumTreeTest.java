package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeToGreaterSumTreeTest {

    @Test
    public void should_find_greater_sum_tree() {
        TreeNode root = new TreeNode(4);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootLeftLeft = new TreeNode(0);
        TreeNode rootLeftRight = new TreeNode(2);

        root.left = rootLeft;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;

        TreeNode rootLeftRightRight = new TreeNode(3);
        rootLeftRight.right = rootLeftRightRight;

        TreeNode rootRight = new TreeNode(6);
        TreeNode rootRightLeft = new TreeNode(5);
        TreeNode rootRightRight = new TreeNode(7);
        TreeNode rootRightRightRight = new TreeNode(8);

        root.right = rootRight;
        rootRight.left = rootRightLeft;
        rootRight.right= rootRightRight;
        rootRightRight.right = rootRightRightRight;

        BinarySearchTreeToGreaterSumTree binarySearchTreeToGreaterSumTree = new BinarySearchTreeToGreaterSumTree();
        binarySearchTreeToGreaterSumTree.bstToGst(root);
    }
}