package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Facebook;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
