package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

/**
 * Given an integer array, heapify it into a min-heap array.
 *
 * <p>For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left
 * child of A[i] and A[i * 2 + 2] is the right child of A[i]. Have you met this question in a real
 * interview? Clarification What is heap?
 *
 * <p>Heap is a data structure, which usually have three methods: push, pop and top. where "push"
 * add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return
 * the minimum/maximum element.
 *
 * <p>What is heapify? Convert an unordered integer array into a heap array. If it is min-heap, for
 * each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
 *
 * <p>What if there is a lot of solutions? Return any of them. Example Given [3,2,1,4,5], return
 * [1,2,3,4,5] or any legal heap array.
 *
 * <p>Challenge O(n) time complexity
 */
@FirstRound
@LintCode
@Medium
public class Heapify {

  public void heapify(int[] source) {
    if (source == null || source.length == 0) {
      return;
    }
    int size = source.length;
    System.out.println("Size of number is " + size);
    int currentIndex = 0;
    int leftIndex = 0;
    int rightIndex = 0;
    int son = 0;

    for (int i = size / 2 - 1; i >= 0; --i) {
      currentIndex = i;
      while (currentIndex * 2 + 1 < size) {
        leftIndex = currentIndex * 2 + 1;
        rightIndex = currentIndex * 2 + 2;
        System.out.println(
            "Current index "
                + currentIndex
                + " left inde "
                + leftIndex
                + " right index "
                + rightIndex);
        if (rightIndex >= size || source[leftIndex] <= source[rightIndex]) {
          son = leftIndex;
        } else {
          son = rightIndex;
        }

        if (source[currentIndex] <= source[son]) {
          break;
        } else {
          swap(source, currentIndex, son);
        }
        currentIndex = son;
      }
    }
  }

  private void swap(int[] source, int i, int j) {
    int temp = source[i];
    source[i] = source[j];
    source[j] = temp;
  }
}
