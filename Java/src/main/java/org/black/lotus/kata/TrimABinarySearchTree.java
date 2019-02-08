package org.black.lotus.kata;

import org.black.lotus.marker.*;
import org.black.lotus.org.black.lotus.support.TreeNode;


/**
 * Given the root of a binary search tree and 2 numbers min and max, trim the tree such that all the numbers in the new tree are between min and max (inclusive). The resulting tree should still be a valid binary search tree. So, if we get this tree as input:
 */
@LeetCode
@Medium
@FirstRound
public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int min, int max) {
        if (root == null) {
            return null;
        }

        // FIRST FIX THE LEFT AND
        // RIGHT SUBTREE OF ROOT
        root.left = trimBST(root.left,
                min, max);
        root.right = trimBST(root.right,
                min, max);

        // NOW FIX THE ROOT. THERE ARE
        // TWO POSSIBLE CASES FOR THE ROOT
        // 1. a) Root's key is smaller than
        // min value(root is not in range)
        if (root.val < min) {
            return root.right;
        }

        // 1. b) Root's key is greater than
        // max value (Root is not in range)
        if (root.val > max) {
            return root.left;
        }

        // 2. Root in range
        return root;
    }

}
