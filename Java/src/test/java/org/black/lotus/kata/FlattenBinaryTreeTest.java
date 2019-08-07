package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class FlattenBinaryTreeTest {

    @Test
    public void should_flatten_binary_tree() {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        root.left = rootLeft;
        TreeNode three = new TreeNode(3);
        rootLeft.left = three;
        TreeNode four = new TreeNode(4);
        rootLeft.right = four;

        TreeNode rootRight = new TreeNode(5);
        root.right = rootRight;

        TreeNode rootRightRight = new TreeNode(6);
        rootRight.right = rootRightRight;

        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        LinkedList<Integer> res = flattenBinaryTree.flatten(root);
        res.size();
    }
}