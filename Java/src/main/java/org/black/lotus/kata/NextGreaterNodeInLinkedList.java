package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 *
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
 *
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 *
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.
 *
 * Example 1:
 *
 * Input: [2,1,5]
 * Output: [5,5,0]
 * Example 2:
 *
 * Input: [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 * Example 3:
 *
 * Input: [1,7,5,1,9,2,5,1]
 * Output: [7,9,9,9,0,5,0,0]
 *
 * Downhill stack
 * */
@LeetCode
@Medium
@Accepted
@Important
public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> nodeVals = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            nodeVals.add(tmp.val);
            tmp = tmp.next;
        }
        int[] res = new int[nodeVals.size()];
        Stack<Integer> stack = new Stack<>();

        stack.push(nodeVals.get(nodeVals.size() - 1));
        for (int i = nodeVals.size() - 2; i >= 0; --i) {
            Integer val = nodeVals.get(i);
            if (val < stack.peek()) {
                res[i] = stack.peek();
                stack.push(val);
            } else {
                while(!stack.isEmpty() && val >= stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    res[i] = stack.peek();
                    stack.push(val);
                } else {
                    res[i] = 0;
                    stack.push(val);
                }
            }
        }

        return res;
    }
}
