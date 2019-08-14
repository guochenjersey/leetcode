package org.black.lotus.kata;

import lombok.val;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

 struct Node {
 int val;
 Node *left;
 Node *right;
 Node *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.
 * */
@LeetCode
@Medium
@NoIdeaOrBadIdeaInitially
@Accepted
public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node root) {
        if (root == null)
            return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}


