package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumRootToLeafNumbersTest {

    @Test
    public void should_sum_to_root() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        assertEquals(25, sumRootToLeafNumbers.sumNumbers(root));
    }
}