package org.black.lotus.kata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalIITest {

    @Test
    public void should_print_reversely() {
        BinaryTreeLevelOrderTraversalII binaryTree = new BinaryTreeLevelOrderTraversalII();
        TreeNode root = new TreeNode(3);
        TreeNode root_left = new TreeNode(9);
        TreeNode root_right = new TreeNode(20);
        TreeNode root_right_left = new TreeNode(15);
        TreeNode root_right_right = new TreeNode(7);
        root.left = root_left;
        root.right = root_right;
        root_right.left = root_right_left;
        root_right.right = root_right_right;

        List<List<Integer>> lists = binaryTree.levelOrderBottom(root);
        lists.forEach(l -> {
            for (Integer integer : l) {
                System.out.print(integer + " ");
            }
            System.out.println();
        });

        BinaryTreePath binaryTreePath = new BinaryTreePath();
        binaryTreePath.binaryTreePaths(root).forEach(s -> {
            System.out.println(s);
        });
    }
}