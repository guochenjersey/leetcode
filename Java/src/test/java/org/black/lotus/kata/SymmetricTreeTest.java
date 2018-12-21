package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricTreeTest {

    @Test
    public void should_find_symmetric() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(4);
        TreeNode leftLeft = new TreeNode(5);
        TreeNode rightRight = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        right.right = rightRight;

        SymmetricTree symmetricTree = new SymmetricTree();
        boolean res = symmetricTree.isSymmetricLevelTraverse(root);
        assertTrue(res);
    }
}