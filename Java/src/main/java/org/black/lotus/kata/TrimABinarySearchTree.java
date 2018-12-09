package org.black.lotus.kata;

import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NotAccepted;


/**
 * Given the root of a binary search tree and 2 numbers min and max, trim the tree such that all the numbers in the new tree are between min and max (inclusive). The resulting tree should still be a valid binary search tree. So, if we get this tree as input:
 *
 * */
@LintCode
@Medium
@NotAccepted
public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        if (root == null) {
            return null;
        }

        while (root != null && (root.val < minimum || root.val > maximum)) {
            if (root.val < minimum) {
                root = root.right;
                continue;
            }
            if (root.val > maximum) {
                root = root.left;
                continue;
            }
        }

        if (root == null) {
            return null;
        }

        trim(root, root.left, minimum, maximum, true);
        trim(root, root.right, minimum, maximum, false);

        return root;
    }

    private void trim(TreeNode parent, TreeNode node, int min, int max, boolean isLeft) {
        if (node == null) {
            return;
        }

        if (node.val < min && isLeft) {
            parent.left = node.right;
        }

        if (node.val > max && !isLeft) {
            parent.right = node.left;
        }

        trim(node, node.left, min, max, true);
        trim(node, node.right, min, max, false);
    }
}
