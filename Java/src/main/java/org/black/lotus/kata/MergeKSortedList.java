package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Description
 Merge k sorted linked lists and return it as one sorted list.

 Analyze and describe its complexity.

 Have you met this question in a real interview?
 Example
 Given lists:

 [
 2->4->null,
 null,
 -1->null
 ],
 return -1->2->4->null.
 *
 *
 * 我一开始的想法还是使用MIN HEAP来排序.
 * */
@LintCode
@Medium
@FirstRound
public class MergeKSortedList {

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Queue<ListNode> listNodesHeap = setupHeap(lists);
        return convert(listNodesHeap);
    }

    private Queue<ListNode> setupHeap(List<ListNode> lists) {
        Queue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            while (node != null) {
                priorityQueue.offer(node);
                node = node.next;
            }
        }

        return priorityQueue;
    }

    private ListNode convert(Queue<ListNode> priorityQueue) {
        ListNode headSentinel = new ListNode(-1);
        ListNode current = headSentinel;
        while (!priorityQueue.isEmpty()) {
            current.next = priorityQueue.poll();
            current = current.next;
        }

        current.next = null;
        return headSentinel.next;
    }
}
