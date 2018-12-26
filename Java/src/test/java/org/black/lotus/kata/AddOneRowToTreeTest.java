package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddOneRowToTreeTest {

    @Test
    public void should_add_one_row_to_tree_1() {
        TreeNode root = new TreeNode(4);
        TreeNode rootLeftChild = new TreeNode(2);
        TreeNode rootRightChild = new TreeNode(6);
        rootLeftChild.left = new TreeNode(3);
        rootLeftChild.right = new TreeNode(1);
        rootRightChild.left = new TreeNode(5);
        root.left = rootLeftChild;
        root.right = rootRightChild;

        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
        TreeNode res = addOneRowToTree.addOneRow(root, 1, 2);
        System.out.println(res);
    }


    @Test
    public void should_add_one_row_to_tree_2() {
        TreeNode root = new TreeNode(4);
        TreeNode rootLeftChild = new TreeNode(2);
        rootLeftChild.left = new TreeNode(3);
        rootLeftChild.right = new TreeNode(1);
        root.left = rootLeftChild;

        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
        TreeNode res = addOneRowToTree.addOneRow(root, 1, 3);
        System.out.println(res);
    }
}