package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Facebook;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * onvert a binary search tree to doubly linked list with in-order traversal.

 Example
 Example 1：

 Input:
 4
 / \
 2   5
 / \
 1   3

 Output: 1<->2<->3<->4<->5
 Example 2：

 Input:
 3
 / \
 4   1

 Output:4<->3<->1
 *
 * */
@LintCode
@Facebook
@Medium
@Accepted
public class ConvertABinarySearchTreeToDoublyLinkedList {

    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<DoublyListNode> res = new ArrayList<>();
        inOrder(root, res);

        return res.get(0);
    }

    private void inOrder(TreeNode node, List<DoublyListNode> res) {
        if (node == null) {
            return;
        }

        inOrder(node.left, res);
        DoublyListNode n = new DoublyListNode(node.val);
        if (res.size() == 0) {
            res.add(n);
        } else {
            DoublyListNode prev = res.get(res.size() - 1);
            prev.next = n;
            n.prev = prev;
            res.add(n);
        }
        inOrder(node.right, res);
    }
}
