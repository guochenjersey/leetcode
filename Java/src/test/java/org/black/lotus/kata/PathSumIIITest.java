package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathSumIIITest {

    @Test
    public void should_find_path_sum() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        PathSumIII pathSumIII = new PathSumIII();

        assertEquals(3, pathSumIII.pathSum(root, 8));
    }
}