package org.black.lotus.kata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreePathSumTest {

    @Test
    public void should_find_binary_search_path() {
        TreeNode node = new TreeNode();
        node.val = 1;

        TreeNode two = new TreeNode();
        two.val = 2;

        TreeNode four = new TreeNode();
        four.val = 4;

        TreeNode two2 = new TreeNode();
        two2.val = 2;

        TreeNode three = new TreeNode();
        three.val = 3;

        node.left = two;
        node.right = four;
        two.left = two2;
        two.right = three;

        BinaryTreePathSum binaryTreePathSum = new BinaryTreePathSum();
        List<List<Integer>> res = binaryTreePathSum.binaryTreePathSum(node, 5);
    }
}