package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AverageOfLevelsInBinaryTreeTest {

    @Test
    public void should_find_average_of_levels_in_binary_tree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree
                = new AverageOfLevelsInBinaryTree();
        List<Double> res = averageOfLevelsInBinaryTree.averageOfLevels(root);

        res.forEach(System.out::println);
    }
}