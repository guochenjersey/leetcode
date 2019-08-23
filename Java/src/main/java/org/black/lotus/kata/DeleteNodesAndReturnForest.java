package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@LeetCode
@Medium
@Accepted
public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Set<Integer> toRemove = new HashSet<>();
        Arrays.stream(to_delete).forEach(toRemove::add);
        helper(root, toRemove, res, null);

        return res;
    }

    private void helper(TreeNode node,
                        Set<Integer> toRemove,
                        List<TreeNode> res,
                        TreeNode parent) {
        if (node == null) {
            return;
        }

        if (parent == null) {
            if (!toRemove.contains(node.val)) {
                res.add(node);
                helper(node.left, toRemove, res, node);
                helper(node.right, toRemove, res, node);
            } else {
                helper(node.left, toRemove, res, null);
                helper(node.right, toRemove, res, null);

                node.left = null;
                node.right = null;
            }
        } else {
            if (!toRemove.contains(node.val)) {
                helper(node.left, toRemove, res, node);
                helper(node.right, toRemove, res, node);
            } else {
                if (parent.left != null && parent.left.val == node.val) {
                    parent.left = null;
                    helper(node.left, toRemove, res, null);
                    helper(node.right, toRemove, res, null);
                } else {
                    parent.right = null;
                    helper(node.left, toRemove, res, null);
                    helper(node.right, toRemove, res, null);
                }
            }
        }
    }
}
