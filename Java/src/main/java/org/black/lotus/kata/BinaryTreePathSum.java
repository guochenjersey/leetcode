package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
 A valid path is from root node to any of the leaf nodes.
 *
 * */
@LintCode
@FirstRound
public class BinaryTreePathSum {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, root, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode node,
                     int target, int sum) {
        if (node == null) {
            return;
        }

        if ((sum + node.val) == target
                && node.left == null
                && node.right == null) {
            path.add(node.val);
            res.add(new ArrayList<>(path));
            return;
        }

        List<Integer> leftPath = new ArrayList<>(path);
        List<Integer> rightPath = new ArrayList<>(path);
        leftPath.add(node.val);
        rightPath.add(node.val);

        dfs(res, new ArrayList<>(leftPath), node.left, target, sum + node.val);
        dfs(res, new ArrayList<>(rightPath), node.right, target, sum + node.val);
    }
}
