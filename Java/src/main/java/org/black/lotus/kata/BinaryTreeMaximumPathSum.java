package org.black.lotus.kata;

import org.black.lotus.marker.Hard;
import org.black.lotus.marker.HighFrequency;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@LeetCode
@Hard
@HighFrequency
@Important
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> res = new LinkedList<>();
        maxRootPathSum(root, res);

        return res.stream().max(Comparator.comparingInt(a -> a)).get();
    }

    private int maxRootPathSum (TreeNode node, List<Integer> paths) {
        if (node == null) {
            return 0;
        }

        int path = node.val;
        int lMax = maxRootPathSum(node.left, paths);
        int rMax = maxRootPathSum(node.right, paths);

        if (lMax > 0) {
            path += lMax;
        }

        if (rMax > 0) {
            path += rMax;
        }

        paths.add(path);

        int max = Math.max(lMax, rMax);
        return node.val + Math.max(max, 0);
    }
}
