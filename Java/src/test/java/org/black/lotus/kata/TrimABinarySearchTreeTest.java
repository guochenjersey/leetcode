package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrimABinarySearchTreeTest {

    @Test
    public void should_trim() {
        TrimABinarySearchTree trimABinarySearchTree = new TrimABinarySearchTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        TreeNode treeNode = trimABinarySearchTree.trimBST(node1, 8, 9);
        System.out.println(treeNode);
    }
}