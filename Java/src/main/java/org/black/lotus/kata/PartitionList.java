package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * */
@FirstRound
@Easy
@LintCode
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode lessThanHead = null, tempLessThanNode = null;
        ListNode biggerThanHead = null, tempBiggerThanNode = null;

        while (head != null) {
            if (head.val < x) {
                if (lessThanHead == null) {
                    lessThanHead = head;
                    tempLessThanNode = head;
                } else {
                    tempLessThanNode.next = head;
                    tempLessThanNode = tempLessThanNode.next;
                }
            } else {
                if (biggerThanHead == null) {
                    biggerThanHead = head;
                    tempBiggerThanNode = head;
                } else {
                    tempBiggerThanNode.next = head;
                    tempBiggerThanNode = tempBiggerThanNode.next;
                }
            }
            head = head.next;
        }
        if (tempLessThanNode != null) {
            tempLessThanNode.next = null;
        }

        if (tempBiggerThanNode != null) {
            tempBiggerThanNode.next = null;
        }

        if (lessThanHead == null) {
            return biggerThanHead;
        }

        if (biggerThanHead == null) {
            return lessThanHead;
        }

        tempLessThanNode.next = biggerThanHead;

        return lessThanHead;
    }
}
