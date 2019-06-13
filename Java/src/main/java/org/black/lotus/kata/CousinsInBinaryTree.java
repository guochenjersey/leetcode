package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 993
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 * */
@LeetCode
@Easy
@Accepted
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair();
        p.parent = null;
        p.child = root;

        queue.offer(p);
        Pair foundX = null;
        Pair foundY = null;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize != 0) {
                Pair p1 = queue.poll();
                if (p1.child.left != null) {
                    Pair p2 = new Pair();
                    p2.parent = p1.child;
                    p2.child = p1.child.left;
                    queue.offer(p2);
                }

                if (p1.child.right != null) {
                    Pair p2 = new Pair();
                    p2.parent = p1.child;
                    p2.child = p1.child.right;
                    queue.offer(p2);
                }

                --levelSize;
                if (p1.child.val == x) {
                    foundX = p1;
                } else if (p1.child.val == y) {
                    foundY = p1;
                }

                if (foundX != null && foundY != null
                        && foundX.parent != null && foundY.parent != null
                        && foundX.parent.val != foundY.parent.val) {
                    return true;
                }
            }

            foundX = null;
            foundY = null;
        }

        return false;
    }

    class Pair {
        TreeNode parent;
        TreeNode child;
    }
}
