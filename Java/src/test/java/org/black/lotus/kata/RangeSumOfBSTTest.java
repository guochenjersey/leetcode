package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangeSumOfBSTTest {

    @Test
    public void should_sum_range_of_bst() {
        TreeNode root = new TreeNode(10);
        TreeNode rootLeft = new TreeNode(5);
        root.left = rootLeft;

        TreeNode rootRight = new TreeNode(15);
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(3);
        rootLeft.left = rootLeftLeft;

        TreeNode rootLeftRight = new TreeNode(7);
        rootLeft.right = rootLeftRight;

        TreeNode rootRightRight = new TreeNode(18);
        rootRight.right= rootRightRight;

        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();
        int res = rangeSumOfBST.rangeSumBST(root, 7, 15);

        assertEquals(32, res);
    }

}