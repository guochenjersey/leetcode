package org.black.lotus.kata;

import org.black.lotus.marker.BinarySearch;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NotAccepted;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

 Example:

 Input: 3
 Output:
 [
 [1,null,3,2],
 [3,2,null,1],
 [3,1,null,null,2],
 [2,1,3],
 [1,null,2,null,3]
 ]
 Explanation:
 The above output corresponds to the 5 unique BST's shown below:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 *
 *TODO
 * */
@LeetCode
@Medium
@BinarySearch
@NotAccepted
public class UniqueBinarySearchTreeII {

    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> nodes = init(n);
        return null;
    }

    private TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        if (root.val < node.val) {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }

        if (root.val > node.val) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        }

        return root;
    }

    private ArrayList<TreeNode> copyOf(List<TreeNode> nodes) {
        ArrayList<TreeNode> copyOf = new ArrayList<>();
        for (TreeNode node : nodes) {
            TreeNode copyNode = new TreeNode(node.val);
            copyOf.add(copyNode);
        }

        return copyOf;
    }

    private ArrayList<TreeNode> init(int n) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            TreeNode node = new TreeNode(i);
            nodes.add(node);
        }

        return nodes;
    }
}
