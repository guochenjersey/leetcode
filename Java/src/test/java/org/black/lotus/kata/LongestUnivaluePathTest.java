package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestUnivaluePathTest {

    @Test
    public void should_find_longest_univalue_path() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();

        assertEquals(2, longestUnivaluePath.longestUnivaluePath(root));
    }
}