package org.black.lotus.kata;

import org.black.lotus.marker.*;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:
 Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 Output: Reference of the node with value = 8
 Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

 Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 Output: Reference of the node with value = 2
 Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.


 Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 Output: null
 Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 Explanation: The two lists do not intersect, so return null.

 * */
@LeetCode
@Easy
@FirstRound
@LinkedLists
@NoIdeaOrBadIdeaInitially
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = findLength(headA);
        int bLength = findLength(headB);
        if (aLength == 0 || bLength == 0) {
            return null;
        }

        ListNode longer;
        ListNode shorter;
        if (aLength > bLength) {
            longer = headA;
            shorter = headB;
        } else {
            longer = headB;
            shorter = headA;
        }

        int diff = Math.abs(aLength - bLength);
        while (diff != 0) {
            longer = longer.next;
            --diff;
        }

        while (bLength != 0) {
            if (longer.val == shorter.val &&
                    longer.val != 0) {
                return longer;
            } else {
                longer = longer.next;
                shorter = shorter.next;
            }

            --bLength;
        }

        return null;
    }

    private int findLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            ++length;
        }

        return length;
    }
}
