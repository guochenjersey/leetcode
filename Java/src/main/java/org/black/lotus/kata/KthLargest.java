package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * */
@LeetCode
@Easy
public class KthLargest {

    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
        }
        this.k = k;
    }

    public int add(int val) {
        pq.add(val);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
