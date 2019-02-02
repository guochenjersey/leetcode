package org.black.lotus.kata;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertBSTToGreaterTreeTest {

    @Test
    public void should_convert_bst_to_greater_tree() {
        TreeNode root = new TreeNode(5);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode thirteen = new TreeNode(13);
        root.left = rootLeft;
        root.right = thirteen;

        ConvertBSTToGreaterTree convertBSTToGreaterTree =
                new ConvertBSTToGreaterTree();
        convertBSTToGreaterTree.convertBST(root);
    }
}